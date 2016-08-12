package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.ProductDao;
import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.Product;
import com.inbadevs.swimmingpool.entities.User;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.manager.controlAccess.Access;
import com.inbadevs.swimmingpool.manager.controlAccess.ControlAccessFactory;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ManagerAccessControl {

    private UserDao userDao;
    private ProductDao productDao;
    private ControlAccessFactory controlAccessFactory;


    @Autowired
    public ManagerAccessControl(UserDao userDao, ProductDao productDao, ControlAccessFactory controlAccessFactory){
        this.userDao = userDao;
        this.productDao = productDao;
        this.controlAccessFactory = controlAccessFactory;
    }

    public ManagerAccessControl() {}


    public ControlAccessResponse isUserAccessControlEntrance(Long userId, Long productId, Date entranceDate) throws NotFoundException, ControlEntranceException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startValidDate = dateFormat.parse(product.getStartValidDate(), new ParsePosition(0));

        Date endValidDate = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));
        Calendar endValidDateCalendar = Calendar.getInstance();
        endValidDateCalendar.setTime(endValidDate);
        endValidDateCalendar.set(Calendar.HOUR, 23);
        endValidDateCalendar.set(Calendar.MINUTE, 59);
        endValidDateCalendar.set(Calendar.SECOND, 59);


        if(entranceDate.after(startValidDate) && entranceDate.before(endValidDateCalendar.getTime())){

            Access controlAccess = controlAccessFactory.getControlAccess(product.getProductPK().getPlan().getTypeOfPlan());
            return controlAccess.controlEntrance(user, product, entranceDate);

        }
        else {
            throw new ControlEntranceException("range");
        }


    }


    public ControlAccessResponse isUserAccessControlExit(Long userId, Long productId, Date exitDate) throws NotFoundException, ControlExitException {

        User user = this.userDao.find(userId);
        Product product = this.productDao.find(productId);

        Access controlAccess = controlAccessFactory.getControlAccess(product.getProductPK().getPlan().getTypeOfPlan());
        return controlAccess.controlExit(user, product, exitDate);

    }



}
