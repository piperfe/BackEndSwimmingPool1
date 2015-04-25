package com.inbadevs.swimmingpoolserviceusers.dao;

import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
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

  /*  public List<User> getAllUsers() throws ExceptionQueryNotFound {
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
    }*/
}