package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerUsers;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service
@Path("users")
public class ServiceRestUsers {

    @Autowired
    ManagerUsers usersManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login/{idUser}/{password}")
    public BooleanResponse loginUser(@PathParam("idUser") String idUser, @PathParam("password") String password) {
        Boolean result =  this.usersManager.loginUser(idUser, password);
        return new BooleanResponse(result);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("isUserExist/{id}")
    public BooleanResponse isUserExist(@PathParam("id") String idUser) throws javassist.NotFoundException {
        Boolean result = this.usersManager.isUserExist(idUser);
        return new BooleanResponse(result);
    }


    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") Long idUser) throws BuisnessLayerException {
        this.usersManager.deleteUser(idUser);

    }

}
