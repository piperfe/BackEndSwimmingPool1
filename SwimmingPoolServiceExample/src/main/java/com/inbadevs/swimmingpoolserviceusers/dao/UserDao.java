package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by macbook on 4/17/15.
 */
@Component
public class UserDao extends BaseGenericDAO<User>{

    @Autowired
    protected UserDao(
            @Qualifier("sessionFactory") SessionFactory em) {
        super(User.class, em);
    }

}
