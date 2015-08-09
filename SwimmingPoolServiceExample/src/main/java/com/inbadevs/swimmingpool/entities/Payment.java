/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Getter
public class Payment implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private SwimmingPoolUser swimmingPoolUser;

    @ManyToOne
    private AdminUser adminUser;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @Temporal(TemporalType.DATE)
    private Date datepay;

    @Column(unique = true)
    String numberOfTicket;

    String formOfPayment;

    String chequeNumber;

    String bank;

    String observations;

    public Payment() {
        this.datepay = new Date();
    }
}
