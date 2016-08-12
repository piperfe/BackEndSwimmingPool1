/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.HistoryConnection;
import com.inbadevs.swimmingpool.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class HistoryConnectionDao extends BaseGenericDAO<HistoryConnection>{
    
     @Autowired
    public HistoryConnectionDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(HistoryConnection.class, em);
    }
    
    public void insert(User user)
    {
        HistoryConnection history = new HistoryConnection();
        history.setUser(user);
        this.save(history);
        
    }
}
