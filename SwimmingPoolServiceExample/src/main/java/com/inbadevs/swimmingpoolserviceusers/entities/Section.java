/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
public class Section implements Serializable{
    
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    
    private Time start;
    
    private Time end;
    
    
}
