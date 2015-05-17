/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.SwimmingPoolUserDao;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerSwimmingPoolUsers {

    @Autowired
    SwimmingPoolUserDao swimmingPoolUserDao;


    public List<SwimmingPoolUser> getAllSwimmingPoolUsers() {
        return this.swimmingPoolUserDao.all();
    }

    public void addUser(SwimmingPoolUser user) {
        this.swimmingPoolUserDao.save(user);
    }

    public void modifySwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.swimmingPoolUserDao.update(user);
    }

    public List<SwimmingPoolUser> searchUsers(String pattern) throws BuisnessLayerException {
        return this.swimmingPoolUserDao.search(pattern);
    }

    public SwimmingPoolUser search(Long idSwimmingPoolUser) throws NotFoundException {
        return this.swimmingPoolUserDao.find(idSwimmingPoolUser);
    }


}
