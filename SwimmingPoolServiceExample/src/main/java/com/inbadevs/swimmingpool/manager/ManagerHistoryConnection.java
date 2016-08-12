/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.HistoryConnectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.inbadevs.swimmingpool.entities.User;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerHistoryConnection {
    
    @Autowired
    HistoryConnectionDao HistoryConnectionDao;
    
    public void addHistoryConnection (User user){
        this.HistoryConnectionDao.insert(user);
    }
    
}
