/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Plan implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    
    private String name;
    
    private String description;

    private Long price;

    //TODO Improve enum type of data
    private String typeOfPlan;

    private Integer hoursPerWeek;

    private Integer blocksPerWeek;

}