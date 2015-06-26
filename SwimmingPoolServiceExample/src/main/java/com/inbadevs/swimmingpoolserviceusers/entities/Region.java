/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */
@Entity
@Getter
public class Region implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    
}
