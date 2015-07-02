package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class ProductDao extends BaseGenericDAO<Product>{

    @Autowired
    public ProductDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Product.class, em);
    }

}
