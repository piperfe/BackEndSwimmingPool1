/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @NotNull
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date enter;
    
    private String comment;
    
    
}
