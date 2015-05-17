/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class Assistance implements Serializable  {

    public Assistance() {
        this.enter = new Date();
    }

    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date enter;
    
    private String comment;
    
    
}
