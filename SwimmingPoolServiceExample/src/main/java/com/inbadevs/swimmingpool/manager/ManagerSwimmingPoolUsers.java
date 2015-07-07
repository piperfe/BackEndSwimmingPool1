/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.SwimmingPoolUserDao;
import com.inbadevs.swimmingpool.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
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
        user.setProfile(1);
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
