/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Category;
import com.inbadevs.swimmingpool.entities.Item;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerItem;
import java.util.List;
import javassist.NotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("/item")
public class ServiceRestItem {
    
    @Autowired
    ManagerItem managerItem;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Item> getAllItem() throws BuisnessLayerException {
        return this.managerItem.getAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getOne/{id}")
    public Item getOneItem(@PathParam("id") Long id) throws javassist.NotFoundException {
        return this.managerItem.getOne(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addItem(Item item) throws BuisnessLayerException{
        this.managerItem.addItem(item);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modify")
    public void modifyItem(Item item) throws BuisnessLayerException{
        this.managerItem.updateItem(item);
    }
    
    @DELETE
    @Path("/delete/{id}")
    public void deleteSchedule(@PathParam("id") Long id) throws BuisnessLayerException {
        this.managerItem.deleteItem(id);
    }
    
}
