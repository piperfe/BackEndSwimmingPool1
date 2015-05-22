package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by macbook on 3/30/15.
 */
@Entity
@Getter
public class AdminUser extends User implements Serializable {

    private String position;
    
}
