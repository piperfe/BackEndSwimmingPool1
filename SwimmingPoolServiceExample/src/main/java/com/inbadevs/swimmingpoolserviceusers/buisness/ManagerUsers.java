package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.UserDao;
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

    public Boolean loginUser(String idUser, String password) {
        User user = this.userDao.login(idUser, password);
        if(user != null){
            return true;
        }
        return false;
    }

    public Boolean isUserExist(String idUser) throws NotFoundException {
        User user = this.userDao.find(idUser);
        if(user != null){
            return true;
        }
        return false;
    }

    public void deleteUser(String idUser) throws BuisnessLayerException {
        this.userDao.delete(idUser);
    }
}
