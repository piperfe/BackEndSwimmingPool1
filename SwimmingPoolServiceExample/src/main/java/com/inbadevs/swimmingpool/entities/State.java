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

public class State implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    private String description;
    
    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description.toUpperCase();
    }
    
    
    
}
