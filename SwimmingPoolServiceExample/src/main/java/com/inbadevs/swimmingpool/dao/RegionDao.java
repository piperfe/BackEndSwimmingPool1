/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.dao.BaseGenericDAO;
import com.inbadevs.swimmingpool.entities.Region;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class RegionDao extends  BaseGenericDAO<Region> {
    
    @Autowired
    public RegionDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Region.class, em);
    }

}
