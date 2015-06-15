/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author gabriellopezsalinas
 *
 * */

@Entity
@Getter
public class Payment implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private SwimmingPoolUser swimmingPoolUser;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepay;

    public Payment() {
        this.datepay = new Date();
    }
}
