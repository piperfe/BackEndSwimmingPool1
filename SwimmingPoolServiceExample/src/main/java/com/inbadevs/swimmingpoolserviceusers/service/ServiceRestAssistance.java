/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerAssistance;
import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPlan;
import com.inbadevs.swimmingpoolserviceusers.entities.Assistance;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriellopezsalinas
 */


@Service
@Path("/assistance")
public class ServiceRestAssistance {
    
    @Autowired
    ManagerAssistance buissnesLayer;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Assistance> getAllAssistance() throws BuisnessLayerException {
        List<Assistance> assistance = this.buissnesLayer.getAllAssistance();
        return assistance;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addAssistance(Assistance assistance) throws BuisnessLayerException {
        this.buissnesLayer.addAssistance(assistance);
        return Response.ok().build();
    }
}
