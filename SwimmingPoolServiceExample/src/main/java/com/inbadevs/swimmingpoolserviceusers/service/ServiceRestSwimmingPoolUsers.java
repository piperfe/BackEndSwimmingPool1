package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerSwimmingPoolUsers;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("users/swimmingPool")
public class ServiceRestSwimmingPoolUsers {

    @Autowired
    ManagerSwimmingPoolUsers usersManager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public List<SwimmingPoolUser> getAllSwimmingPoolUsers() throws BuisnessLayerException {
        List<SwimmingPoolUser> users = this.usersManager.getAllSwimmingPoolUsers();
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addSwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.usersManager.addUser(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modify")
    public void modifySwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.usersManager.modifySwimmingPoolUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchUsers/{pattern}")
    public List<SwimmingPoolUser> searchUsers(@PathParam("pattern") String pattern) throws BuisnessLayerException {
        List<SwimmingPoolUser> users = this.usersManager.searchUsers(pattern);
        return users;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public SwimmingPoolUser search(@PathParam("id") Long idSwimmingPoolUser) throws javassist.NotFoundException {
        return this.usersManager.search(idSwimmingPoolUser);
    }


}