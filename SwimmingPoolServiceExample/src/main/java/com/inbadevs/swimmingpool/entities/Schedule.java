/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Plan plan;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<DaySection> daySection;

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description.toUpperCase();
    }
    
}