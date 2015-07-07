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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ManagerAccessControl {

    private UserDao userDao;
    private ProductDao productDao;
    private AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;
    private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startValidDate = sdf.parse(product.getStartValidDate(), new ParsePosition(0));
        Date endValidDate = sdf.parse(product.getEndValidDate(), new ParsePosition(0));

        Date today = new Date();

        if(today.after(startValidDate) && today.before(endValidDate)){

            Plan plan = product.getProductPK().getPlan();
            isUserAccessControlFreeHoursPlanEntrance(user, plan, today);

            final Double hours = Double.valueOf(plan.getHoursPerWeek() * 4);
            Double hoursLeft = hours;

            CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);

            if(countHoursLeft != null){
                hoursLeft = countHoursLeft.getHoursLeft();
            }

            return new ControlAccessResponse(user.getNames(), plan.getName(), hours, hoursLeft);

        }
        else {
            throw new ControlEntranceException("range");
        }

    }

    public ControlAccessResponse isUserAccessControlExit(Long userId, Long productId) throws NotFoundException, ControlExitException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);
        Date today = new Date();
        Plan plan = product.getProductPK().getPlan();

        if(plan.getTypeOfPlan().equals("typeHoursPerWeek")) {

            AssistanceFreeHoursPlan assistanceFreeHoursPlan = assistanceFreeHoursPlanDao.findLastEntrance(user, plan);

            if(assistanceFreeHoursPlan == null){
                throw new ControlExitException("never entrance");
            }

            Long difference = today.getTime() - assistanceFreeHoursPlan.getEntranceDate().getTime();
            Double differenceHours = Double.valueOf(difference) / 3600000;

            CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);

            Double hoursLeft;

            if(countHoursLeft != null){
                hoursLeft = countHoursLeft.getHoursLeft() - differenceHours;
                countHoursLeft.setHoursLeft(hoursLeft);
            }
            else{
                hoursLeft = Double.valueOf(plan.getHoursPerWeek() * 4) - differenceHours;
                countLeftHoursFreeHoursPlanDao.save(new CountLeftHoursFreeHoursPlan(user, plan, hoursLeft));
            }

            assistanceFreeHoursPlan.setEntrance(false);
            assistanceFreeHoursPlan.setExitDate(today);

            return new ControlAccessResponse(user.getNames(), plan.getName(), Double.valueOf(plan.getHoursPerWeek() * 4) , hoursLeft);

        }

        return null;
    }



    private void isUserAccessControlFreeHoursPlanEntrance(User user, Plan plan, Date today) throws ControlEntranceException {

        if(plan.getTypeOfPlan().equals("typeHoursPerWeek")) {

            /*AssistanceFreeHoursPlan assistanceFreeHoursPlan = assistanceFreeHoursPlanDao.findLastEntrance(user, plan);
            if(assistanceFreeHoursPlan != null && !assistanceFreeHoursPlan.getEntrance()){
                throw new ControlEntranceException("not entrance never");
            }*/
            assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, plan));

        }
    }
}