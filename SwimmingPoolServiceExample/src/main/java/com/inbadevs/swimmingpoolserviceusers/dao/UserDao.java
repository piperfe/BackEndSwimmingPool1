package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.exceptions.ExceptionQueryNotFound;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
@Transactional("transactionManager")
public class UserDao extends BaseAbstractDAO<User, Integer> {

    @Autowired
    protected UserDao(
            @Qualifier("sessionFactory") SessionFactory em,
            @Value("#{users}") Map<String, String> userDaoImplQueries) {
        super(User.class, em, userDaoImplQueries);
    }

    protected UserDao() {

    }

    public List<User> getAllUsers() throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("getAllUsers");
        query.addEntity(User.class);
        return query.list();
    }

    public void addUser(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("insertUser");
        query.setParameter(0, user.getUserName());
        query.setParameter(1, user.getPassword());
        query.setParameter(2, user.getEmail());
        query.addEntity(User.class);
    }

}
