package com.inbadevs.swimmingpoolserviceusers.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inbadevs.swimmingpoolserviceusers.exceptions.ExceptionQueryNotFound;

public class BaseAbstractDAO<E, I extends Serializable> {

    private Class<E> entityClass;

    private Map<String, String> queries;

    private SessionFactory sessionFactory;

    public BaseAbstractDAO(Class<E> entityClass, SessionFactory sessionFactory, Map<String, String> q) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
        getQueries().putAll(q);
    }

    public BaseAbstractDAO() {
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private Map<String, String> getQueries() {
        if (this.queries == null) {
            this.queries = new HashMap<String, String>();
        }

        return this.queries;
    }

    public SQLQuery createSqlQuery(String methodName) throws ExceptionQueryNotFound {
        
        String sql = getQueries().get(methodName);

        if (sql == null) {
            throw new ExceptionQueryNotFound("La query [" + methodName
                    + "] no ha sido encontrada");
        }

        return getCurrentSession().createSQLQuery(sql);
    }

}
