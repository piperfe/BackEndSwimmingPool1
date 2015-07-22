package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AssistanceFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.CountLeftHoursFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.ProductDao;
import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import javassist.NotFoundException;
import lombok.Setter;
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

    private UserDao userDao;
    private ProductDao productDao;
    private AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;
    private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;

    @Setter
    private Date entranceDate;

    @Setter
    private Date exitDate;

    @Autowired
    public ManagerAccessControl(UserDao userDao, ProductDao productDao,
                                AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao,
                                CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao){
        this.userDao = userDao;
        this.productDao = productDao;
        this.assistanceFreeHoursPlanDao = assistanceFreeHoursPlanDao;
        this.countLeftHoursFreeHoursPlanDao = countLeftHoursFreeHoursPlanDao;
    }

    public ManagerAccessControl() {}


    public ControlAccessResponse isUserAccessControlEntrance(Long userId, Long productId) throws NotFoundException, ControlEntranceException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startValidDate = dateFormat.parse(product.getStartValidDate(), new ParsePosition(0));
        Date endValidDate = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));

        entranceDate =  (entranceDate != null) ? entranceDate : new Date();

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

                if(todayCal.after(startCal) && todayCal.before(endCal)){
                    assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));
                    return new ControlAccessResponse(user.getNames(), schedule.getName(), null, null, true);
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

        return new ControlAccessResponse(user.getNames(), plan.getName(), hours, hoursLeft, false);
    }

    public ControlAccessResponse isUserAccessControlExit(Long userId, Long productId) throws NotFoundException, ControlExitException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);
        Plan plan = product.getProductPK().getPlan();

        exitDate =  (exitDate != null) ? exitDate : new Date();

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
                    leftHours, false);

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
