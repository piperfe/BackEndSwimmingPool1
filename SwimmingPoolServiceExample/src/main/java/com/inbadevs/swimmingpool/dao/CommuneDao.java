/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Commune;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class CommuneDao extends BaseGenericDAO<Commune>{
    
    @Autowired
    public CommuneDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Commune.class, em);
    }
    public List<Commune> findAllCommuneByIdRegion(Long idRegion) {
        Criteria criteria = getCurrentSession().createCriteria(Commune.class)
                .add(Restrictions.eq("region.id", idRegion));
        return criteria.list();
    }    
}
