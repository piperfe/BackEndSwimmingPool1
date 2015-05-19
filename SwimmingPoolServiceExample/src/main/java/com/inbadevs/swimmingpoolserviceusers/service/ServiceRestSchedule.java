/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerSchedule;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public void modifySchedule(Schedule schedule) throws BuisnessLayerException {
        this.managerSchedule.modifySchedule(schedule);
    }
    
    @DELETE
    @Path("/delete/{id}")
    public void deleteSchedule(@PathParam("id") Long id) throws BuisnessLayerException {
        this.managerSchedule.deleteSchedule(id);

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
