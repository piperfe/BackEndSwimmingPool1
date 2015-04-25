/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPlan;
import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerSchedule;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
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
@Path("/schedule")

public class ServiceRestSchedule {
  
    
    @Autowired
    ManagerSchedule buissnesLayer;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Schedule> getAllPlan() throws BuisnessLayerException {
        List<Schedule> schedule = this.buissnesLayer.getAllSchedule();
        return schedule;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addSchedule(Schedule schedule) throws BuisnessLayerException {
        this.buissnesLayer.addSchedule(schedule);
        return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public void modifySchedule(Schedule schedule) throws BuisnessLayerException {
        this.buissnesLayer.modifySchedule(schedule);
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlan(@PathParam("id") Integer id) throws BuisnessLayerException {
        this.buissnesLayer.deleteSchedule(id);
        return Response.ok().build();

    }
}
