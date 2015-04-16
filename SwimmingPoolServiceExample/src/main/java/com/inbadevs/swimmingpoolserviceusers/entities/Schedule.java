/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@XmlRootElement
@Entity
@Getter

public class Schedule implements Serializable {
    
    @Id
    private String id;
    
    private String start_time;
    
    private String hora_fin;
    
    private String monday;
    
    private String tuesday;
    
    private String wednesday;
    
    private String thurday;
    
    private String friday;
    
    private String saturday;
    
    private String sunday;
    
}