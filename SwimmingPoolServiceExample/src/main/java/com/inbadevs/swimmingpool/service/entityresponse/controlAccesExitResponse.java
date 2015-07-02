/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service.entityresponse;

import lombok.Getter;


@Getter
public class controlAccesExitResponse {
    private Boolean result;

    public controlAccesExitResponse(Boolean result){
        this.result = result;
    }

}
