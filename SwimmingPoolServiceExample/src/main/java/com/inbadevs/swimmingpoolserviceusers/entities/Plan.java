/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;

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
    @NotNull
    private Integer id;
    
    private String name;
    
    private String description;
    
    @ManyToOne
    private Schedule schedule;

   
}