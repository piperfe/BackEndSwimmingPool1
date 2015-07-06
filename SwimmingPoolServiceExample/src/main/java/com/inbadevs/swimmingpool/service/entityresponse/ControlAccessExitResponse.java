/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service.entityresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ControlAccessExitResponse {

    private String userName;
    private String nameOfPlan;
    private Integer hoursOfPlan;
    private Double leftHours;


}
