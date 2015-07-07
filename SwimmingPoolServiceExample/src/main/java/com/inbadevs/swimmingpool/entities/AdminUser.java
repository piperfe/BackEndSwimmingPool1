package com.inbadevs.swimmingpool.entities;

import lombok.Getter;

import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Getter
public class AdminUser extends User implements Serializable {

    private String position;
    
}
