/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter

public class Plan implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    
    private String name;
    
    private String description;

    private Long price;

    private Integer hoursPerWeek;

 /*   @Temporal(javax.persistence.TemporalType.DATE)
    private Date startValidDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endValidDate;

    @ManyToOne
    private Schedule schedule;*/
   
}