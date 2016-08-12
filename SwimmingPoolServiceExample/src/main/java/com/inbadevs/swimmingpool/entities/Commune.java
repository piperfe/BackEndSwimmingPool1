/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
public class Commune implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Region region;
    
    private String name;

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    
    
}
