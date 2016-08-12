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
public class CountLeftHoursSchedulePlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    User user;

    @OneToOne
    Product product;

    @Setter
    Integer blocksPenalty;

    @Setter
    Integer leftHours;

    Integer scheduleTotalBlocks;

    public CountLeftHoursSchedulePlan(User user, Product product, Integer scheduleTotalBlocks, Integer leftHours, Integer blocksPenalty){

        this.user = user;
        this.product = product;
        this.scheduleTotalBlocks = scheduleTotalBlocks;
        this.leftHours = leftHours;
        this.blocksPenalty = blocksPenalty;
    }

}
