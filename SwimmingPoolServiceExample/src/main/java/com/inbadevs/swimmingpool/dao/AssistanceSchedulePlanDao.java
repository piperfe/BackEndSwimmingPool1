/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.AssistanceSchedulePlan;
import com.inbadevs.swimmingpool.entities.Plan;
import com.inbadevs.swimmingpool.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
public class AssistanceSchedulePlanDao extends BaseGenericDAO<AssistanceSchedulePlan>{


    @Autowired
    public AssistanceSchedulePlanDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(AssistanceSchedulePlan.class, em);
    }

    public AssistanceSchedulePlan findLastEntrance(User user, Plan plan) {
        Criteria criteria = getCurrentSession().createCriteria(AssistanceSchedulePlan.class)
                .add(Restrictions.and(Restrictions.eq("user", user),
                        Restrictions.eq("plan", plan))).addOrder(Order.desc("entranceDate"));

        List<AssistanceSchedulePlan> assistanceFreeHoursPlanList = (List<AssistanceSchedulePlan>) criteria.list();

        if(assistanceFreeHoursPlanList != null && !assistanceFreeHoursPlanList.isEmpty()){
            return assistanceFreeHoursPlanList.get(0);
        }
        return null;

    }

}
