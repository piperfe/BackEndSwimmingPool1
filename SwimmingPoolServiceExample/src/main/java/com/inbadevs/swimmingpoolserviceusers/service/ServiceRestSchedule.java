/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerSchedule;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.BooleanResponse;
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
@Path("/schedule")

public class ServiceRestSchedule {
  
    
    @Autowired
    ManagerSchedule managerSchedule;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Schedule> getAllSchedule() throws BuisnessLayerException {
        List<Schedule> schedule = this.managerSchedule.getAllSchedule();
        return schedule;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addSchedule(Schedule schedule) throws BuisnessLayerException {
        this.managerSchedule.addSchedule(schedule);
        return Response.ok().entity(new BooleanResponse(true)).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public Response modifySchedule(Schedule schedule) throws BuisnessLayerException {
        this.managerSchedule.modifySchedule(schedule);
        return Response.ok().entity(new BooleanResponse(true)).build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePlan(@PathParam("id") Integer id) throws BuisnessLayerException {
        this.managerSchedule.deleteSchedule(id);
        return Response.ok().build();

    }
}
