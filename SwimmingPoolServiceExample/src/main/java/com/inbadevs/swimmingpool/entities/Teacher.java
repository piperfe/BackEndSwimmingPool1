/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.Getter;

import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Getter
public class Teacher extends User implements Serializable{
    
    private String comments;
}