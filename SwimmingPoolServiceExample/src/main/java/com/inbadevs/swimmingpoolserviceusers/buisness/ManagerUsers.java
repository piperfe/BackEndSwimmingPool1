package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.UserDao;
import com.inbadevs.swimmingpoolserviceusers.entities.AdminUser;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by macbook on 4/17/15.
 */
@Component
public class ManagerUsers {

    @Autowired
    UserDao userDao;


    public Boolean isUserExist(String rut) throws NotFoundException {
        User user = this.userDao.findBy("rut", rut);
        if(user != null){
            return true;
        }
        return false;
    }

    public void deleteUser(Long idUser) throws BuisnessLayerException {
        this.userDao.delete(idUser);
    }
    
    public User loginUser(String rut, String password) {
        User user = this.userDao.login(rut, password);
        if(user != null){
            return user;
        }
        return null;
    }
}
