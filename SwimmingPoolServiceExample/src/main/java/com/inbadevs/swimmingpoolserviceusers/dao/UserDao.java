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
        query.setParameter(0, user.getIdUser());
        query.setParameter(1, user.getUserNames());
        query.setParameter(2, user.getApellidoPaterno());
        query.setParameter(3, user.getApellidoMaterno());
        query.setParameter(4, user.getFechaNacimiento());
        query.setParameter(5, user.getDireccion());
        query.setParameter(6, user.getComuna());
        query.setParameter(7, user.getClave());
        query.setParameter(8, user.getCorreo());
        query.setParameter(9, user.getTelefono());
        query.addEntity(User.class);
        query.executeUpdate();
    }
    
    public void addUserPiscina(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("insertUserPiscina");
        query.setParameter(0, user.getIdUser());
        query.setParameter(1, user.getCertificadoMedico());
        query.setParameter(2, user.getEnfermedades());
        query.setParameter(3, user.getObservaciones());
        query.addEntity(User.class);
        query.executeUpdate();
    }
    
    
    public void addUserAdmin(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("insertUserAdmin");
        query.setParameter(0, user.getIdUser());
        query.setParameter(1, user.getCertificadoMedico());
        query.setParameter(2, user.getEnfermedades());
        query.setParameter(3, user.getObservaciones());
        query.addEntity(User.class);
        query.executeUpdate();
    }
    
    public void deleteUser(String idUser) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("deleteUser");
        query.setParameter(0, idUser);
        query.addEntity(User.class);
        query.executeUpdate();
    }

    public void deleteUserPiscina(String idUser) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("deleteUserPiscina");
        query.setParameter(0, idUser);
        query.addEntity(User.class);
        query.executeUpdate();
    }
    
    public void modifyUser(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("modifyUser");
        query.setParameter(0, user.getUserNames());
        query.setParameter(1, user.getApellidoPaterno());
        query.setParameter(2, user.getApellidoMaterno());
        query.setParameter(3, user.getFechaNacimiento());
        query.setParameter(4, user.getDireccion());
        query.setParameter(5, user.getComuna());
        query.setParameter(6, user.getClave());
        query.setParameter(7, user.getCorreo());
        query.setParameter(8, user.getTelefono());
        query.setParameter(9, user.getIdUser());
        query.addEntity(User.class);
        query.executeUpdate();
    }
    
    public List<User> getUser(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("getUser");
        query.setParameter(0, user.getIdUser());
        query.setParameter(1, user.getClave());
        
        query.addEntity(User.class);
        return query.list();
    }
        
    public List<User> userExist(User user) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("userExist");
        query.setParameter(0, user.getIdUser());
        query.addEntity(User.class);
        return query.list();
    }
        
    public List<User> searchUsers(String varSearch) throws ExceptionQueryNotFound {
        SQLQuery query = createSqlQuery("searchUsers");
        query.setParameter(0,"%"+varSearch+"%");
        query.setParameter(1,"%"+varSearch+"%");
        query.addEntity(User.class);
        return query.list();
    }
}
