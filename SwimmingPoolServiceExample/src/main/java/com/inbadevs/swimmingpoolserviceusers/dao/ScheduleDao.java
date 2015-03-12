/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
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
public class ScheduleDao extends BaseAbstractDAO<Schedule, Integer> {

    @Autowired
    protected ScheduleDao(
            @Qualifier("sessionFactory") SessionFactory em,
            @Value("#{users}") Map<String, String> scheduleDaoImplQueries) {
        super(Schedule.class, em, scheduleDaoImplQueries);
    }

    protected ScheduleDao() {

    }

    public List<User> getAllSchedule() throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("getAllschedule");
        query.addEntity(User.class);
        return query.list();
    }

    
    public void deleteUser(int idUser) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("deleteUser");
        query.setParameter(0, idUser);
        query.addEntity(User.class);
        query.executeUpdate();
    }


    
        public List<User> getUser() throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("getUser");
        query.addEntity(User.class);
        return query.list();
    }
}
