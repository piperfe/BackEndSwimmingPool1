package com.inbadevs.swimmingpool.manager.controlAccess;

import com.inbadevs.swimmingpool.dao.AssistanceSchedulePlanDao;
import com.inbadevs.swimmingpool.dao.CountLeftHoursSchedulePlanDao;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by macbook on 8/8/15.
 */
@Component
public class ScheduleAccess implements Access{

    public static final int TIME_ENTRANCE_DELAY = -20;
    private AssistanceSchedulePlanDao assistanceSchedulePlanDao;
    private CountLeftHoursSchedulePlanDao countLeftHoursSchedulePlanDao;

    @Autowired
    public ScheduleAccess (AssistanceSchedulePlanDao assistanceSchedulePlanDao,
                           CountLeftHoursSchedulePlanDao countLeftHoursSchedulePlanDao){

        this.assistanceSchedulePlanDao = assistanceSchedulePlanDao;
        this.countLeftHoursSchedulePlanDao = countLeftHoursSchedulePlanDao;
    }

    public ControlAccessResponse controlEntrance(User user, Product product, Date today) throws ControlEntranceException {

        Schedule schedule = product.getProductPK().getSchedule();

        for(DaySection daySection: schedule.getDaySection()){

            String day = daySection.getDaySection().getDay().getName();

            Calendar todayCal = Calendar.getInstance();
            todayCal.setTime(today);
            int val = todayCal.get(Calendar.DAY_OF_WEEK);
            String dayOfWeek = new DateFormatSymbols().getWeekdays()[val];

            if(day.equals(dayOfWeek)){

                Time start = daySection.getDaySection().getSection().getStart();
                Calendar startCal = Calendar.getInstance();
                startCal.setTime(start);
                startCal.set(Calendar.DAY_OF_YEAR, todayCal.get(Calendar.DAY_OF_YEAR));
                startCal.set(Calendar.YEAR, todayCal.get(Calendar.YEAR));

                Time end = daySection.getDaySection().getSection().getEnd();
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(end);
                endCal.set(Calendar.DAY_OF_YEAR, todayCal.get(Calendar.DAY_OF_YEAR));
                endCal.set(Calendar.YEAR, todayCal.get(Calendar.YEAR));

                startCal.add(Calendar.MINUTE, TIME_ENTRANCE_DELAY);

                if(todayCal.after(startCal) && todayCal.before(endCal)){

                    assistanceSchedulePlanDao.save(new AssistanceSchedulePlan(user, product.getProductPK().getSchedule()
                            , daySection, today, true));

                    CountLeftHoursSchedulePlan countLeftHoursSchedulePlan = countLeftHoursSchedulePlanDao.find(user, product);

                    int scheduleTotalBlocks;
                    int penaltiesBlockSchedule = 0;
                    int leftHours = 0;

                    if(countLeftHoursSchedulePlan == null){

                        scheduleTotalBlocks = calculateBlocksOfSchedule(product, today);
                        leftHours = scheduleTotalBlocks;
                        countLeftHoursSchedulePlanDao.save(new CountLeftHoursSchedulePlan(user, product,
                                scheduleTotalBlocks, leftHours, penaltiesBlockSchedule));
                    }
                    else{

                        scheduleTotalBlocks = countLeftHoursSchedulePlan.getScheduleTotalBlocks();
                        penaltiesBlockSchedule = countLeftHoursSchedulePlan.getBlocksPenalty();
                        leftHours = countLeftHoursSchedulePlan.getLeftHours();
                    }

                    return new ControlAccessResponse(user.getNames(), product.getProductPK().getPlan().getName(),
                            null, leftHours, scheduleTotalBlocks,penaltiesBlockSchedule);
                }

            }
        }

        throw new ControlEntranceException("invalid entrance, schedule without daySection");
    }


    public ControlAccessResponse controlExit(User user, Product product, Date exitDate) throws ControlExitException {

        Plan plan = product.getProductPK().getPlan();
        Schedule schedule = product.getProductPK().getSchedule();
        AssistanceSchedulePlan assistanceSchedulePlan = assistanceSchedulePlanDao.findLastEntrance(user, schedule);

        if(assistanceSchedulePlan == null ){
            throw new ControlExitException("never entrance");
        }
        else if(!assistanceSchedulePlan.getEntrance()){
            throw new ControlExitException("entrance before exit");
        }

        CountLeftHoursSchedulePlan countLeftHoursSchedulePlan = countLeftHoursSchedulePlanDao.find(user, product);

        int penaltyHours = hasPenalty(exitDate, assistanceSchedulePlan.getEntranceDate());
        countLeftHoursSchedulePlan.setBlocksPenalty(penaltyHours);
        countLeftHoursSchedulePlan.setLeftHours(countLeftHoursSchedulePlan.getLeftHours()
                - penaltyHours - 1);
        assistanceSchedulePlan.setEntrance(false);
        assistanceSchedulePlan.setExitDate(exitDate);

        return new ControlAccessResponse(user.getNames(), plan.getName(),
                null, countLeftHoursSchedulePlan.getLeftHours(), countLeftHoursSchedulePlan.getScheduleTotalBlocks(), countLeftHoursSchedulePlan.getBlocksPenalty());
    }

    private Integer hasPenalty(Date exitDate, Date entranceDate) {

        Long difference = exitDate.getTime() - entranceDate.getTime();
        Long minutes = difference / (60 * 1000);

        if(minutes <= 100){
            return 0;
        }

        int penaltyMinutes = 100;
        int i = 0;

        while (penaltyMinutes < minutes){

            if(minutes > penaltyMinutes){
                i++;
            }
            penaltyMinutes = penaltyMinutes + 60;
        }

        return  i;

    }

    private int calculateBlocksOfSchedule(Product product, Date today) {

        Schedule schedule = product.getProductPK().getSchedule();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date endScheduleDay = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));
        Calendar endScheduleDayCalendar = Calendar.getInstance();
        endScheduleDayCalendar.setTime(endScheduleDay);
        endScheduleDayCalendar.set(Calendar.HOUR, 23);
        endScheduleDayCalendar.set(Calendar.MINUTE, 59);
        endScheduleDayCalendar.set(Calendar.SECOND, 59);

        long diff = endScheduleDayCalendar.getTime().getTime() - today.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        //long diffHours = diff / (60 * 60 * 1000) % 24;
        //diffDays = (diffDays == 0 && diffHours > 0) ?  0 : 1;

        Calendar initialScheduleDayCalendar = Calendar.getInstance();
        initialScheduleDayCalendar.setTime(today);
        int startVal = initialScheduleDayCalendar.get(Calendar.DAY_OF_WEEK);
        String initialScheduleDayOfWeek = new DateFormatSymbols().getWeekdays()[startVal];

        int blocksOfSchedule = 0;

        for(int i = 0; i <= diffDays; i ++){

            for(DaySection daySection: schedule.getDaySection()) {

                String day = daySection.getDaySection().getDay().getName();

                if (day.equals(initialScheduleDayOfWeek)) {

                    blocksOfSchedule ++;
                }
            }

            startVal ++;
            if(startVal == 8){
                startVal = 1;
            }
            initialScheduleDayOfWeek = new DateFormatSymbols().getWeekdays()[startVal];

        }

        return blocksOfSchedule;

    }
}
