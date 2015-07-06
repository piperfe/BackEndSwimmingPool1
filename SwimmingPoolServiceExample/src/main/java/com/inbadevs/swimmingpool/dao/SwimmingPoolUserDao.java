package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.SwimmingPoolUser;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@EnableTransactionManagement
//@Transactional("transactionManager")
public class SwimmingPoolUserDao extends BaseGenericDAO<SwimmingPoolUser> {

    @Autowired
    protected SwimmingPoolUserDao(
            @Qualifier("sessionFactory") SessionFactory em) {
        super(SwimmingPoolUser.class, em);
    }

    public List<SwimmingPoolUser> search(String pattern) {
        Criteria criteria = getCurrentSession().createCriteria(SwimmingPoolUser.class)
                .add(Restrictions.or(Restrictions.like("rut", pattern, MatchMode.ANYWHERE),
                        Restrictions.like("firstLastName", pattern, MatchMode.ANYWHERE)))
                .addOrder(Order.asc("rut"));
        return criteria.list();
    }

}
