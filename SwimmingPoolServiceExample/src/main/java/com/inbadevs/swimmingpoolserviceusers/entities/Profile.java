/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@XmlRootElement
@Entity
@Getter
public class Profile implements Serializable{

    @Id
    private String id;
    
    private String description;
    
}
