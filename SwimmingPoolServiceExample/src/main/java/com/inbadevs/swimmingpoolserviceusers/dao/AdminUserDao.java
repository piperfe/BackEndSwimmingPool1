package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.AdminUser;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by macbook on 4/4/15.
 */
@Component
public class AdminUserDao extends  BaseGenericDAO<AdminUser>{

    @Autowired
    protected AdminUserDao(
            @Qualifier("sessionFactory") SessionFactory em) {
        super(AdminUser.class, em);
    }

    public AdminUser login(String rut, String password) {
        Criteria criteria = getCurrentSession().createCriteria(AdminUser.class)
                .add(Restrictions.and(Restrictions.eq("rut", rut),
                        Restrictions.eq("password", password)));
        return (AdminUser) criteria.uniqueResult();
    }

}
