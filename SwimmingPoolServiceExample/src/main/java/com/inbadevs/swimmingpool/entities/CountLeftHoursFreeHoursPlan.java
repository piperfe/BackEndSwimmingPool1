/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CountLeftHoursFreeHoursPlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    User user;

    @OneToOne
    Plan plan;

    @Setter
    Integer hoursLeft;

    public  CountLeftHoursFreeHoursPlan(User user, Plan plan, Integer hoursLeft){

        this.user = user;
        this.plan = plan;
        this.hoursLeft = hoursLeft;
    }

}
