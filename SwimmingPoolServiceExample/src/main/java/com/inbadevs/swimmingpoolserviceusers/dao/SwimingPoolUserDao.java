/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.exceptions.ExceptionQueryNotFound;
import java.util.List;
import java.util.Map;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gabriellopezsalinas
 */



@Repository
@EnableTransactionManagement
@Transactional("transactionManager")
public class SwimingPoolUserDao extends BaseAbstractDAO<SwimingPoolUserDao, Integer> {
    @Autowired
    protected SwimingPoolUserDao(
            @Qualifier("sessionFactory") SessionFactory em,
            @Value("#{SwimingPoolUsers}") Map<String, String> userDaoImplQueries) {
        super(SwimingPoolUserDao.class, em, userDaoImplQueries);
    }

    protected SwimingPoolUserDao() {

    }

    public List<User> getAllUsers() throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("getAllUsers");
        query.addEntity(User.class);
        return query.list();
    }
    
}
