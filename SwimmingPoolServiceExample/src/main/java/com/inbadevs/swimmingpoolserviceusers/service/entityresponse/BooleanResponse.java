/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service.entityresponse;

import lombok.Getter;

/**
 * @author gabriellopezsalinas
 */
@Getter
public class BooleanResponse {
    private Boolean result;

    public BooleanResponse(Boolean result){
        this.result = result;
    }

}
