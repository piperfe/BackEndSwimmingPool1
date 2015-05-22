/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPlan;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    public void addPlan(Plan plan) throws BuisnessLayerException {
        this.buissnesLayer.addPlan(plan);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public void modifyPlan(Plan plan) throws BuisnessLayerException {
        this.buissnesLayer.modifyPlan(plan);
    }
    
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlan(@PathParam("id") Long id) throws BuisnessLayerException {
        List<Schedule> schedules = this.buissnesLayer.deletePlan(id);

        if(schedules.size() > 0){
            return Response.ok().entity(schedules).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Plan search(@PathParam("id") Long idPlan) throws javassist.NotFoundException {
        return this.buissnesLayer.search(idPlan);
    }


}
