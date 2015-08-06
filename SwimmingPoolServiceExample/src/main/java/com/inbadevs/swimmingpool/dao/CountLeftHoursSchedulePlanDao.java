/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.CountLeftHoursSchedulePlan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class CountLeftHoursSchedulePlanDao extends BaseGenericDAO<CountLeftHoursSchedulePlan>{


    @Autowired
    public CountLeftHoursSchedulePlanDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(CountLeftHoursSchedulePlan.class, em);
    }

}
