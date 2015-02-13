/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.exceptions.ExceptionQueryNotFound;
import com.inbadevs.swimmingpoolserviceusers.dao.UserDao;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuisnessLayer {

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() throws BuisnessLayerException {

        try {
            return this.userDao.getAllUsers();
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getAllUsers message=user not found");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void addUser(User user) throws BuisnessLayerException{
        
        try {
            this.userDao.addUser(user);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=addUser message=user didn't add");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
