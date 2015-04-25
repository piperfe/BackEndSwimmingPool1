/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class ScheduleDao extends BaseGenericDAO<Schedule>{

    @Autowired
    public ScheduleDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Schedule.class, em);
    }
    
    List<Schedule> getAll2_0() {
       Criteria criteria = getCurrentSession().createCriteria(Schedule.class)
               .add(Restrictions.sqlRestriction(""));
       return criteria.list();
    }
}
