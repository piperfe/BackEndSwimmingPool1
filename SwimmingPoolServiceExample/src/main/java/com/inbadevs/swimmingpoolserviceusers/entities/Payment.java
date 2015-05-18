/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long id;
    
    @ManyToOne
    private SwimmingPoolUser swimmingpooluser;
    
    @ManyToOne
    private Product product;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepay;
    
    //private Long numberticket;
    
    public Payment() {
        this.datepay = new Date();
    }
}
