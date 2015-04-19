package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerSwimmingPoolUsers;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response addSwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.usersManager.addUser(user);
        return Response.ok().entity(new BooleanResponse(true)).build();
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
    @Path("searchById/{id}")
    public SwimmingPoolUser searchById(@PathParam("id") String idSwimmingPoolUser) throws javassist.NotFoundException {
        return this.usersManager.searchById(idSwimmingPoolUser);
    }


}