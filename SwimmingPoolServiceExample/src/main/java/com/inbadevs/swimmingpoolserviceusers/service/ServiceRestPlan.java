/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerUser;
import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPlan;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Path("/plan")

public class ServiceRestPlan {
   
    @Autowired
    ManagerPlan buissnesLayer;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Plan> getAllPlan() throws BuisnessLayerException {
        List<Plan> plan = this.buissnesLayer.getAllPlan();
        return plan;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addPlan(Plan plan) throws BuisnessLayerException {
        this.buissnesLayer.addPlan(plan);
        return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public void modifyPlan(Plan plan) throws BuisnessLayerException {
        this.buissnesLayer.modifyPlan(plan);
    }
    
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlan(@PathParam("id") Integer id) throws BuisnessLayerException {
        this.buissnesLayer.deletePlan(id);
        return Response.ok().build();

    }
    
}
