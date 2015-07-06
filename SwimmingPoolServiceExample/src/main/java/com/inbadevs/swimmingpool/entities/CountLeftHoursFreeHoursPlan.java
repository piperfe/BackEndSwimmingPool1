/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Entity
@Getter
@AllArgsConstructor
public class CountLeftHoursFreeHoursPlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    User user;

    @OneToOne
    Plan plan;

    @Setter
    Double hoursLeft;

    public  CountLeftHoursFreeHoursPlan(User user, Plan plan, Double hoursLeft){

        this.user = user;
        this.plan = plan;
        this.hoursLeft = hoursLeft;
    }

    public CountLeftHoursFreeHoursPlan(){}

}
