/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Day implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
}
