/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPayment;
import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerPlan;
import com.inbadevs.swimmingpoolserviceusers.entities.Payment;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
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
@Path("/payment")
public class ServiceRestPayment {
    
    @Autowired
    ManagerPayment buissnesLayer;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Payment> getAllPayment() throws BuisnessLayerException {
        List<Payment> payment = this.buissnesLayer.getAllPayment();
        return payment;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void addPayment(Payment payment) throws BuisnessLayerException {
        this.buissnesLayer.addPayment(payment);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    public void modifyPayment(Payment payment) throws BuisnessLayerException {
        this.buissnesLayer.modifyPayment(payment);
    }
    
    
    @DELETE
    @Path("/delete/{id}")
    public Response deletePayment(@PathParam("id") Long id) throws BuisnessLayerException {
        this.buissnesLayer.deletePayment(id);
        return Response.ok().build();

    }
}
