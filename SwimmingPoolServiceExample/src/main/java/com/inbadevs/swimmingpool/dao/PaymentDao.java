/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Payment;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class PaymentDao extends BaseGenericDAO<Payment>{
    
    @Autowired
    public PaymentDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Payment.class, em);
    }

    public List<Payment> closeTurn(Long idUserAdmin) {

        Criteria criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("adminUser", FetchMode.JOIN)
                .add(Restrictions.eq("adminUser.id", idUserAdmin))
                .add(Restrictions.eq("datepay", (new Date())));
 
        return criteria.list();

    }

    public List<Payment> getPaymentsBySwimmingPoolUser(Long swimmingPoolUserId) {

        Criteria criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("swimmingPoolUser", FetchMode.JOIN)
                .add(Restrictions.eq("swimmingPoolUser.id", swimmingPoolUserId));
        return criteria.list();

    }
    
    
    public List<Payment> getPaymentsActiveBySwimmingPoolUser(Long swimmingPoolUserId) {

        Criteria criteria;
        criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("swimmingPoolUser", FetchMode.JOIN)
                .add(Restrictions.eq("swimmingPoolUser.id", swimmingPoolUserId))
                //setFetchMode("product", FetchMode.JOIN).
                .add(Restrictions.eqProperty("product.id","product" ))
                .add(Restrictions.ge("product.startValidDate", (new SimpleDateFormat("dd/MM/yyy")).toString()))
                .add(Restrictions.le("product.endValidDate", (new SimpleDateFormat("dd/MM/yyy")).toString()))
               ;
        return criteria.list();

    }


}
