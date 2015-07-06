/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Schedule;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerSchedule;
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
    public void addSchedule(Schedule schedule) throws BuisnessLayerException {
        this.managerSchedule.addSchedule(schedule);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public Response modifySchedule(Schedule schedule) throws BuisnessLayerException {
        Boolean isDeletedSchedule = this.managerSchedule.modifySchedule(schedule);

        if(isDeletedSchedule){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok().entity(isDeletedSchedule).status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response deleteSchedule(@PathParam("id") Long id) throws BuisnessLayerException {
        Boolean isDeletedSchedule = this.managerSchedule.deleteSchedule(id);

        if(isDeletedSchedule){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok().entity(isDeletedSchedule).status(Response.Status.OK).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Schedule search(@PathParam("id") Long idSchedule) throws javassist.NotFoundException {
        return this.managerSchedule.search(idSchedule);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchScheduleRestriction/{pattern}")
    public List<Schedule> searchSchedule(@PathParam("pattern") int sizeRestriction) throws BuisnessLayerException {
        List<Schedule> schedules = this.managerSchedule.searchScheduleRestriction(sizeRestriction);
        return schedules;
    }
}
