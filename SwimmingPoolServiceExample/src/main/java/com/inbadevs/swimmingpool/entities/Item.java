/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Item implements Serializable{
    
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String description;
    
    private String unitMeasure;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private State state;
    
}
