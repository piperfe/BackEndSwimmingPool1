package com.inbadevs.swimmingpoolserviceusers.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import java.util.List;


public class BaseGenericDAO<E> {

    private Class<E> entityClass;
    private SessionFactory sessionFactory;

    public BaseGenericDAO(Class<E> entityClass, SessionFactory em) {
        this.entityClass = entityClass;
        this.sessionFactory = em;
    }

    public void save(E entity){
        this.getCurrentSession().save(entity);
    }

    public void delete(String id) {
        this.getCurrentSession().delete(this.getCurrentSession().get(entityClass, id));
    }

    public void update(E entity){
        this.getCurrentSession().update(entity);
    }

    public List<E> all() {
        Criteria criteria = getCurrentSession().createCriteria(entityClass).addOrder(Order.asc("id"));
        return criteria.list();
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
