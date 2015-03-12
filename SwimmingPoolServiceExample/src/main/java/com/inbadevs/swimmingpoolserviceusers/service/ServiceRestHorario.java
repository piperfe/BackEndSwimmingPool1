/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.BuisnessLayer;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriellopezsalinas
 */
@Service
@Path("/schedule")
public class ServiceRestHorario {
    
        @Autowired
        BuisnessLayer buissnesLayer;
        
//        
//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//	@Path("/getAllschedule")
//	public List<User> getAllschedule() throws BuisnessLayerException {
//		List<User> schedule = this.buissnesLayer.getAllSchedule();
//                return schedule;
//	}
        
//        @PUT
//        @Produces(MediaType.APPLICATION_JSON)
//        @Consumes(MediaType.APPLICATION_JSON)
//	@Path("/addSchedule")
//	public void AddSchedule(Schedule schedule) throws BuisnessLayerException {
//		this.buissnesLayer.addSchedule(schedule);
//	}
//        
//        @DELETE
//        @Path("/deleteSchedule/{id}")
//	public void DeleteSchedule(@PathParam("id") int idSchedule) throws BuisnessLayerException {
//		this.buissnesLayer.deleteSchedule(idSchedule);
//	}
//        
//        @PUT
//        @Produces(MediaType.APPLICATION_JSON)
//        @Consumes(MediaType.APPLICATION_JSON)
//	@Path("/modifySchedule")
//	public void ModifySchedule(Schedule schedule) throws BuisnessLayerException {
//		this.buissnesLayer.modifySchedule(schedule);
//	}
}