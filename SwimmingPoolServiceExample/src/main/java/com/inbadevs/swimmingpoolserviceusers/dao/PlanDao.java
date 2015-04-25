package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class PlanDao extends BaseGenericDAO<Plan>{

    @Autowired
    public PlanDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Plan.class, em);
    }
    
}
