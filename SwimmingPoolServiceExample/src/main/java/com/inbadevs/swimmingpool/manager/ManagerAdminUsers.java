/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AdminUserDao;
import com.inbadevs.swimmingpool.entities.AdminUser;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerAdminUsers {

    @Autowired
    AdminUserDao adminUserDao;


    public List<AdminUser> getAllAdminUsers() {
        return this.adminUserDao.all();
    }

    public void addUser(AdminUser user) {
        user.setProfile(2);
        this.adminUserDao.save(user);
    }

    public void modifyAdminUser(AdminUser user) {
        this.adminUserDao.update(user);
    }

    public AdminUser search(Long idAdminUser) throws NotFoundException {
        return this.adminUserDao.find(idAdminUser);
    }

}
