package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerAdminUsers;
import com.inbadevs.swimmingpoolserviceusers.entities.AdminUser;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("users/admin")
public class ServiceRestAdminUsers {

    @Autowired
    ManagerAdminUsers managerAdminUsers;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public List<AdminUser> getAllAdminUsers() throws BuisnessLayerException {
        List<AdminUser> users = this.managerAdminUsers.getAllAdminUsers();
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response addAdminUser(AdminUser user) throws BuisnessLayerException {
        this.managerAdminUsers.addUser(user);
        return Response.ok().entity(new BooleanResponse(true)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modify")
    public void modifyAdminUser(AdminUser user) throws BuisnessLayerException {
        this.managerAdminUsers.modifyAdminUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchById/{id}")
    public AdminUser searchById(@PathParam("id") String idAdminUser) throws javassist.NotFoundException {
        return this.managerAdminUsers.searchById(idAdminUser);
    }


}