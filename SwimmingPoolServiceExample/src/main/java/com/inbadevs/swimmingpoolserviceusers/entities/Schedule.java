/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
public class Schedule implements Serializable {
    
    @Id
    @GeneratedValue
    @NotNull
    private Integer id;
    
    private String name;
    
    private String description;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<DaySection> daysection;
    
}