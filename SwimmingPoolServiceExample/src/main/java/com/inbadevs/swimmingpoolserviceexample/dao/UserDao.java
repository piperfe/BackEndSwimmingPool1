package com.inbadevs.swimmingpoolserviceexample.dao;

import com.inbadevs.swimmingpoolserviceexample.entities.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManager")
public class UserDao extends BaseAbstractDAO<User, Integer> {

    @Autowired
    public UserDao(
            @Qualifier("sessionFactory") SessionFactory em
            //@Value("#{example}") Map<String, String> userDaoImplQueries) {
            ){
            super(User.class, em);
    }

    public List<User> getAllUsers()
            throws Exception {
        try {
            SQLQuery query = createSqlQuery("SELECT id_user, user_name, password FROM test.user limit 1");
            query.addEntity(User.class);
            List<User> a = query.list();
            return a;
        } catch (HibernateException e) {
            throw new Exception(e);
        }
    }

}
