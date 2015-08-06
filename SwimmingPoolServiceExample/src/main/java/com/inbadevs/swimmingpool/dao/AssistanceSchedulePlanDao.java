/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.AssistanceSchedulePlan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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


}
