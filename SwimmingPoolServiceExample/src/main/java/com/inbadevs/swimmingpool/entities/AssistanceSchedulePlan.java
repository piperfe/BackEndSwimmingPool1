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
public class AssistanceSchedulePlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Schedule schedule;

    @Setter
    Boolean entrance;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceDate;

    @ManyToOne
    private DaySection daySectionEntrance;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;

    public AssistanceSchedulePlan(User user, Schedule schedule, DaySection daySectionEntrance, Date entranceDate,
                                  Boolean entrance){

        this.user = user;
        this.schedule = schedule;
        this.daySectionEntrance = daySectionEntrance;
        this.entrance = entrance;
        this.entranceDate = entranceDate;
    }


}
