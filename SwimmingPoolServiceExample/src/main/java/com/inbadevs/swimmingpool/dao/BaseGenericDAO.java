package com.inbadevs.swimmingpool.dao;

import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

    public void delete(Integer id) {
        this.getCurrentSession().delete(this.getCurrentSession().get(entityClass, id));
    }

    public void delete(Long id) {
        this.getCurrentSession().delete(this.getCurrentSession().get(entityClass, id));
    }

    public void delete(String id) {
        this.getCurrentSession().delete(this.getCurrentSession().get(entityClass, id));
    }
    
    public void update(E entity){
        this.getCurrentSession().update(entity);
    }

    public List<E> all() {
        Criteria criteria = getCurrentSession().createCriteria(entityClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public E find(String id) throws NotFoundException {
        return (E) this.getCurrentSession().get(entityClass, id);
    }

    public E find(Long id) throws NotFoundException {
        return (E) this.getCurrentSession().get(entityClass, id);
    }

    public E findBy(String name, String value) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass)
                .add(Restrictions.like(name, value));
        return (E) criteria.uniqueResult();
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
