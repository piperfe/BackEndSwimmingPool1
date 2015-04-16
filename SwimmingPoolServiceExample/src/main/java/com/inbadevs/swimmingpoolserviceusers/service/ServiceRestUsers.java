package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerUsers;
import com.inbadevs.swimmingpoolserviceusers.entities.AdminUser;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/users")
public class ServiceRestUsers {

    @Autowired
    ManagerUsers usersManager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("swimmingPool/getAll")
    public List<SwimmingPoolUser> getAllSwimmingPoolUsers() throws BuisnessLayerException {
        List<SwimmingPoolUser> users = this.usersManager.getAllSwimmingPoolUsers();
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("swimmingPool/add")
    public Response addSwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.usersManager.addUser(user);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/swimmingPool/modify")
    public void modifySwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.usersManager.modifySwimmingPoolUser(user);
    }

    @DELETE
    @Path("swimmingPool/delete/{id}")
    public Response deleteSwimmingPoolUser(@PathParam("id") String idUser) throws BuisnessLayerException {
        this.usersManager.deleteSwimmingPoolUser(idUser);
        return Response.ok().build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("swimmingPool/searchUsers/{pattern}")
    public List<SwimmingPoolUser> searchUsers(@PathParam("pattern") String pattern) throws BuisnessLayerException {
        List<SwimmingPoolUser> users = this.usersManager.searchUsers(pattern);
        return users;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addAdminUser")
    public Response addAdminUser(AdminUser user) throws BuisnessLayerException {
        this.usersManager.addUser(user);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login/{id}/{password}")
    public GenericResponse getUser(@PathParam("id") String idUser, @PathParam("password") String password) throws BuisnessLayerException {
        User user = new User();
        //    user.setIdUser(idUser);
        //   user.setClave(password);

        GenericResponse genericResponse = this.usersManager.getUser(user);

        return genericResponse;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/isUserExist/{id}")
    public GenericResponse userExist(@PathParam("id") String idUser) throws BuisnessLayerException {
        User user = new User();
        // user.setIdUser(idUser);

        String status = this.usersManager.userExist(user);

        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setStatus(status);

        return genericResponse;
    }

    //Funcion search, esta retorna una lista con las posibles coincidencias a partir del valor que ingrese
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("swimmingPool/searchById/{id}")
    public User searchById(@PathParam("id") String idUser) throws BuisnessLayerException {
        User user = new User();
        //user.setIdUser(idUser);
        return this.usersManager.searchById(user);

    }


}