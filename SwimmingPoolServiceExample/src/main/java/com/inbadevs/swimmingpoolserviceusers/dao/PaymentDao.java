/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.Payment;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;

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
public class PaymentDao extends BaseGenericDAO<Payment>{
    
    @Autowired
    public PaymentDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Payment.class, em);
    }


    public List<Payment> getPaymentsBySwimmingPoolUser(Long swimmingPoolUserId) {

        Criteria criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("swimmingPoolUser", FetchMode.JOIN)
                .add(Restrictions.eq("swimmingPoolUser.id", swimmingPoolUserId));
        return criteria.list();

    }


}
