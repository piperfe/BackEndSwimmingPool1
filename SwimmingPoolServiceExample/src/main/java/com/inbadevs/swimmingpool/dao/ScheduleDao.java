/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Schedule;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class ScheduleDao extends BaseGenericDAO<Schedule>{

    @Autowired
    public ScheduleDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Schedule.class, em);
    }

}
