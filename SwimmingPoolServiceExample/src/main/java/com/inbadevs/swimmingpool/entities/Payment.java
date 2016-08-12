/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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

    private String datepay;

    @Column(unique = true)
    String numberOfTicket;

    String formOfPayment;

    String chequeNumber;

    String bank;

    String observations;

    public Payment() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.datepay = dateFormat.format(new Date());
    }

    public void setFormOfPayment(String formOfPayment) {
        this.formOfPayment = formOfPayment.toUpperCase();
    }

    public void setBank(String bank) {
        this.bank = bank.toUpperCase();
    }

    public void setObservations(String observations) {
        this.observations = observations.toUpperCase();
    }
    
}
