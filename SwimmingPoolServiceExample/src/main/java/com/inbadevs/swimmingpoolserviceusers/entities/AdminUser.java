package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by macbook on 3/30/15.
 */
@Entity
@Getter
public class AdminUser extends User implements Serializable {

    private String description;
    
    @ManyToOne
    private Profile profile;
    
}
