/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DaySectionPK implements Serializable{
    
  
   @ManyToOne
   Section section;
 
   @ManyToOne
   Day day;

}


