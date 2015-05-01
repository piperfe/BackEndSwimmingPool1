/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author gabriellopezsalinas
 */
@Embeddable
@Getter
public class DaySectionPK implements Serializable{
    
  
   @ManyToOne
   Section section;
 
   @ManyToOne
   Day day;

}
