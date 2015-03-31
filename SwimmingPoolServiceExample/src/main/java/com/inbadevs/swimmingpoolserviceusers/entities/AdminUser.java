package com.inbadevs.swimmingpoolserviceusers.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by macbook on 3/30/15.
 */
@Entity
@Getter
public class AdminUser extends User {

    @NotNull
    @Enumerated(EnumType.STRING)
    private Profile profile;


    public AdminUser(Profile profile) {
        this.profile = profile.OPERATIONS;
    }

    public enum Profile {
        OPERATIONS
    }
}
