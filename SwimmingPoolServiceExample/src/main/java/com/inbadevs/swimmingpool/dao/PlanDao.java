package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Plan;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PlanDao extends BaseGenericDAO<Plan>{

    @Autowired
    public PlanDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Plan.class, em);
    }

    public List<Plan> findAllPlanByTypeOfPlan(String typeOfPlan) {
        Criteria criteria = getCurrentSession().createCriteria(Plan.class)
                .add(Restrictions.eq("typeOfPlan", typeOfPlan));
        return criteria.list();
    }
}
