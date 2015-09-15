/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.State;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author gabriellopezsalinas
 */
public class StateDao extends BaseGenericDAO<State>{
    
    @Autowired
    public StateDao(
            @Qualifier("sessionFactory") SessionFactory em) {
        super(State.class, em);
    }
    
}
