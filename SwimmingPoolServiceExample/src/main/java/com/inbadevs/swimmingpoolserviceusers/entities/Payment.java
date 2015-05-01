/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;

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
    private Plan plan;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepay;
    
    private Long numberticket;
    
    private BigInteger price;
    
    public Payment() {
        this.datepay = new Date();
    }
}
