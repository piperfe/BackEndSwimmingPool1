/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Plan;
import com.inbadevs.swimmingpool.entities.Schedule;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllForName")
    public List<Plan> getAllScheduleForName() throws BuisnessLayerException {
        List<Plan> plan = this.buissnesLayer.getAllForName();
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
    public Response modifyPlan(Plan plan) throws BuisnessLayerException {
        Boolean isModifyPlan = this.buissnesLayer.modifyPlan(plan);

        if(isModifyPlan){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok().entity(isModifyPlan).status(Response.Status.OK).build();
    }
    
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlan(@PathParam("id") Long id) throws BuisnessLayerException {
        Boolean isDeletedPlan = this.buissnesLayer.deletePlan(id);

        if(isDeletedPlan){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok().entity(isDeletedPlan).status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Plan search(@PathParam("id") Long idPlan) throws javassist.NotFoundException {
        return this.buissnesLayer.search(idPlan);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAllPlanByTypeOfPlan/{typeOfPlan}")
    public List<Plan> findAllPlanByTypeOfPlan(@PathParam("typeOfPlan") String typeOfPlan) throws javassist.NotFoundException {
        return this.buissnesLayer.findAllPlanByTypeOfPlan(typeOfPlan);
    }


}
