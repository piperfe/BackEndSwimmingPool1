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

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssistanceFreeHoursPlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Plan plan;

    @Setter
    Boolean entrance;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceDate;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;

    public AssistanceFreeHoursPlan(User user, Plan plan){

        this.user = user;
        this.plan = plan;
        this.entrance = true;
        this.entranceDate = new Date();
    }


}
