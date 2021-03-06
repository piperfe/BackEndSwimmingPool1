/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Payment;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerPayment;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/salesReportBetweenDates/{dateStart}/{dateEnd}")
    public List<Payment> salesReportBetweenDates(@PathParam("dateStart") String dateStart,@PathParam("dateEnd") String dateEnd ) throws BuisnessLayerException, ParseException {
        List<Payment> payment = this.buissnesLayer.salesReportBetweenDates(dateStart,dateEnd);
        return payment;
    }
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/closeTurn/{idUserAdmin}")
    public List<Payment> closeTurn(@PathParam("idUserAdmin") Long idUserAdmin) throws BuisnessLayerException {
        List<Payment> payment = this.buissnesLayer.closeTurn(idUserAdmin);
        return payment;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentId}")
    public Payment getPaymentsById(@PathParam("paymentId") Long paymentId) throws BuisnessLayerException    , javassist.NotFoundException {
        return this.buissnesLayer.getPaymentsById(paymentId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/swimmingPoolUser/{swimmingPoolUserId}")
    public List<Payment> getPaymentsBySwimmingPoolUser(@PathParam("swimmingPoolUserId") Long swimmingPoolUserId) throws BuisnessLayerException {
        List<Payment> payment = this.buissnesLayer.getPaymentsBySwimmingPoolUser(swimmingPoolUserId);
        return payment;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/swimmingPoolUser/infoActive/{swimmingPoolUserId}")
    public List<Payment> getPaymentsActiveBySwimmingPoolUser(@PathParam("swimmingPoolUserId") Long swimmingPoolUserId) throws BuisnessLayerException {
        List<Payment> payment = this.buissnesLayer.getPaymentsActiveBySwimmingPoolUser(swimmingPoolUserId);
        return payment;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/numberOfTicket/{numberOfTicket}")
    public Payment getPaymentsByNumberOfTicket(@PathParam("numberOfTicket") String numberOfTicket) throws BuisnessLayerException {
        Payment payment = this.buissnesLayer.getPaymentsByNumberOfTicket(numberOfTicket);
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
