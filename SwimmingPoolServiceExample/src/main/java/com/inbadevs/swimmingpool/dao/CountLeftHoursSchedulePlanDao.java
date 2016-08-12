/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public CountLeftHoursSchedulePlan find(User user, Product product) {
        Criteria criteria = getCurrentSession().createCriteria(CountLeftHoursSchedulePlan.class)
                .add(Restrictions.and(Restrictions.eq("user", user),
                        Restrictions.eq("product", product)));

        List<CountLeftHoursSchedulePlan> countLeftHoursSchedulePlanList = (List<CountLeftHoursSchedulePlan>) criteria.list();

        if(countLeftHoursSchedulePlanList != null && !countLeftHoursSchedulePlanList.isEmpty()){
            return countLeftHoursSchedulePlanList.get(0);
        }
        return null;
    }

}
