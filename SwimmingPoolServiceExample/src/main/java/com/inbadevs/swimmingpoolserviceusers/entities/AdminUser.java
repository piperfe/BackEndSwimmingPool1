package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by macbook on 3/30/15.
 */
@XmlRootElement
@Entity
@Getter
public class AdminUser extends User implements Serializable {

/*    @NotNull
    @Enumerated(EnumType.STRING)
    private Profile profile;


    public AdminUser(Profile profile) {
        this.profile = profile.OPERATIONS;
    }

    public enum Profile {
        OPERATIONS
    }
*/
    private String description;
    
    @ManyToOne
    private Profile profile;
    
}
