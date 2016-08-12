package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class UserDao extends BaseGenericDAO<User>{

    @Autowired
    protected UserDao(
            @Qualifier("sessionFactory") SessionFactory em) {
        super(User.class, em);
    }

    public User login(String rut, String password) {
        Criteria criteria = getCurrentSession().createCriteria(User.class)
                .add(Restrictions.and(Restrictions.eq("rut", rut),
                        Restrictions.eq("password", password)));
        
        return (User) criteria.uniqueResult();
    }
    


}
