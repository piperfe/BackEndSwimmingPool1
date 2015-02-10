package com.inbadevs.swimmingpoolserviceexample.dao;

import com.inbadevs.swimmingpoolserviceexample.entities.User;
import java.util.List;
import java.util.Map;
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
            @Value("#{example}") Map<String, String> userDaoImplQueries) {
        super(User.class, em, userDaoImplQueries);
    }

    protected UserDao(){
    
    }
    
    public List<User> getAllUsers()
            throws Exception {
        try {
            SQLQuery query = createSqlQuery("example");  
            query.addEntity(User.class);
            return query.list();
        } catch (HibernateException e) {
            throw new Exception(e);
        }
    }

}
