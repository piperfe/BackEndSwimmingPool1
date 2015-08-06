package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.*;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ManagerAccessControl {

    public static final int TIME_ENTRANCE_DELAY = -20;
    private UserDao userDao;
    private ProductDao productDao;
    private AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;
    private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;
    private AssistanceSchedulePlanDao assistanceSchedulePlanDao;
    private CountLeftHoursSchedulePlanDao countLeftHoursSchedulePlanDao;


    @Autowired
    public ManagerAccessControl(UserDao userDao, ProductDao productDao,
                                AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao,
                                CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao,
                                AssistanceSchedulePlanDao assistanceSchedulePlanDao,
                                CountLeftHoursSchedulePlanDao countLeftHoursSchedulePlanDao){
        this.userDao = userDao;
        this.productDao = productDao;
        this.assistanceFreeHoursPlanDao = assistanceFreeHoursPlanDao;
        this.countLeftHoursFreeHoursPlanDao = countLeftHoursFreeHoursPlanDao;
        this.assistanceSchedulePlanDao = assistanceSchedulePlanDao;
        this.countLeftHoursSchedulePlanDao = countLeftHoursSchedulePlanDao;
    }

    public ManagerAccessControl() {}


    public ControlAccessResponse isUserAccessControlEntrance(Long userId, Long productId, Date entranceDate) throws NotFoundException, ControlEntranceException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startValidDate = dateFormat.parse(product.getStartValidDate(), new ParsePosition(0));
        Date endValidDate = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));


        if(entranceDate.after(startValidDate) && entranceDate.before(endValidDate)){

            Plan plan = product.getProductPK().getPlan();

            final String typeHoursPerWeek = "typeHoursPerWeek";
            final String typeBlocksPerWeek = "typeBlocksPerWeek";


            if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeHoursPerWeek)) {

                return controlEntranceFreeHours(user, product, plan);

            }
            else if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeBlocksPerWeek)){

                return controlEntranceSchedule(user, product, entranceDate);
            }


        }
        else {
            throw new ControlEntranceException("range");
        }

        return null;

    }

    private ControlAccessResponse controlEntranceSchedule(User user, Product product, Date today) throws ControlEntranceException {

        Schedule schedule = product.getProductPK().getSchedule();

       /* int totalBlocksOfSchedule = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date initialScheduleDay = dateFormat.parse(product.getStartValidDate(), new ParsePosition(0));
        Date endScheduleDay = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));

        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(initialScheduleDay);
        int val = todayCal.get(Calendar.DAY_OF_WEEK);
        String dayOfWeekInitialScheduleDay = new DateFormatSymbols().getWeekdays()[val];

        while(){

        }*/

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
                    , daySection));
                    return new ControlAccessResponse(user.getNames(), product.getProductPK().getPlan().getName(),
                            null, null, 1,2);
                }

            }
        }

        throw new ControlEntranceException("invalid entrance, schedule without daySection");
    }

    private ControlAccessResponse controlEntranceFreeHours(User user, Product product, Plan plan) {

        assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));
        final int hours = plan.getHoursPerWeek() * 4;
        int hoursLeft = hours;

        CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);

        if(countHoursLeft != null){
            hoursLeft = countHoursLeft.getHoursLeft();
        }

        return new ControlAccessResponse(user.getNames(), plan.getName(), hours, hoursLeft, null, null);
    }

    public ControlAccessResponse isUserAccessControlExit(Long userId, Long productId, Date exitDate) throws NotFoundException, ControlExitException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);
        Plan plan = product.getProductPK().getPlan();

        if(plan.getTypeOfPlan().equals("typeHoursPerWeek")) {

            final int hoursOfPlan = plan.getHoursPerWeek() * 4;
            AssistanceFreeHoursPlan assistanceFreeHoursPlan = assistanceFreeHoursPlanDao.findLastEntrance(user, plan);

            if(assistanceFreeHoursPlan == null ){
                throw new ControlExitException("never entrance");
            }
            else if(!assistanceFreeHoursPlan.getEntrance()){
                throw new ControlExitException("entrance before exit");
            }


            CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);
            Integer leftHours;

            if(countHoursLeft != null){
                leftHours = subtractTime(exitDate, assistanceFreeHoursPlan.getEntranceDate(), countHoursLeft.getHoursLeft());
                countHoursLeft.setHoursLeft(leftHours);
            }
            else{
                leftHours = hoursOfPlan;
                countLeftHoursFreeHoursPlanDao.save(new CountLeftHoursFreeHoursPlan(user, plan, leftHours));
            }

            assistanceFreeHoursPlan.setEntrance(false);
            assistanceFreeHoursPlan.setExitDate(exitDate);

            return new ControlAccessResponse(user.getNames(), plan.getName(), hoursOfPlan,
                    leftHours, null, null);

        }

        return null;
    }

    private Integer subtractTime(Date exitDate, Date entranceDate, int totalHours) {

        Long difference = exitDate.getTime() - entranceDate.getTime();
        Long minutes = difference / (60 * 1000);

        if(minutes > 20){
            return totalHours - 1;
        }
        else{
            return totalHours;
        }

    }

}
