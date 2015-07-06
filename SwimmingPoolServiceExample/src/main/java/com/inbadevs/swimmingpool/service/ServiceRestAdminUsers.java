package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.AdminUser;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerAdminUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public void addAdminUser(AdminUser user) throws BuisnessLayerException {
        this.managerAdminUsers.addUser(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modify")
    public void modifyAdminUser(AdminUser user) throws BuisnessLayerException {
        this.managerAdminUsers.modifyAdminUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public AdminUser search(@PathParam("id") Long idAdminUser) throws javassist.NotFoundException {
        return this.managerAdminUsers.search(idAdminUser);
    }



}