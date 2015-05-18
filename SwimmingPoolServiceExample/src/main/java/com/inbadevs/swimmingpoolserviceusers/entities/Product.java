/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    ProductPK product;
  
}