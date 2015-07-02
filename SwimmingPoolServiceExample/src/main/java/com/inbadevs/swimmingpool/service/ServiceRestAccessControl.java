/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerAccessControl;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessExitResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Service
@Path("/accessControl")
public class ServiceRestAccessControl {
    
    private ManagerAccessControl managerAccessControl;

    @Autowired
    public ServiceRestAccessControl(ManagerAccessControl managerAccessControl){
        this.managerAccessControl = managerAccessControl;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/entrance/{userId}/{productId}")
    public Response isUserAccessControlEntrance(@PathParam("userId") Long userId, @PathParam("productId")
    Long productId) throws BuisnessLayerException, NotFoundException {
        this.managerAccessControl.isUserAccessControlEntrance(userId, productId);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exit/{userId}/{productId}")
    public Response isUserAccessControlExit(@PathParam("userId") Long userId, @PathParam("productId")
    Long productId) throws BuisnessLayerException, NotFoundException {
        ControlAccessExitResponse controlAccessExitResponse = this.managerAccessControl.isUserAccessControlExit(userId, productId);

        if(controlAccessExitResponse != null) {
            return Response.ok().entity(controlAccessExitResponse).build();
        }
        return Response.ok().build();
    }

}
