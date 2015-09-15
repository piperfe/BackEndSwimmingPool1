package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Category;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerCategory;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gabriellopezsalinas
 */

@Service
@Path("category")
public class ServiceRestCategory {
    
    @Autowired
    ManagerCategory categoryManager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public List<Category> getAllCategory() throws BuisnessLayerException{
        return this.categoryManager.getAllCategory();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getOne/{id}")
    public Category getOneCategory(@PathParam("id") String id) throws javassist.NotFoundException {
        return this.categoryManager.getOne(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addCategory(Category category) throws BuisnessLayerException{
        this.categoryManager.addCategory(category);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modify")
    public void modifyCategory(Category category) throws BuisnessLayerException{
        this.categoryManager.updateCategory(category);
    }
    
    
}
