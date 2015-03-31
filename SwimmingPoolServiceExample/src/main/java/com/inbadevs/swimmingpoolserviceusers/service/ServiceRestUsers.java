package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.BuisnessLayer;
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
    BuisnessLayer buissnesLayer;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllSwimmingPoolUsers")
    public List<SwimmingPoolUser> getAllSwimmingPoolUsers() throws BuisnessLayerException {
        List<SwimmingPoolUser> users = this.buissnesLayer.getAllSwimmingPoolUsers();
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addSwimmingPoolUser")
    public Response AddSwimmingPoolUser(SwimmingPoolUser user) throws BuisnessLayerException {
        this.buissnesLayer.addUserPiscina(user);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addAdminUser")
    public Response addAdminUser(AdminUser user) throws BuisnessLayerException {
        this.buissnesLayer.addUserAdmin(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("/deleteUser/{id}")
    public Response DeleteUser(@PathParam("id") String idUser) throws BuisnessLayerException {
        this.buissnesLayer.deleteUser(idUser);
        return Response.ok().build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modifyUser")
    public void ModifyUser(User user) throws BuisnessLayerException {
        this.buissnesLayer.modifyUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login/{id}/{password}")
    public GenericResponse getUser(@PathParam("id") String idUser, @PathParam("password") String password) throws BuisnessLayerException {
        User user = new User();
        //    user.setIdUser(idUser);
        //   user.setClave(password);

        GenericResponse genericResponse = this.buissnesLayer.getUser(user);

        return genericResponse;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/isUserExist/{id}")
    public GenericResponse userExist(@PathParam("id") String idUser) throws BuisnessLayerException {
        User user = new User();
        // user.setIdUser(idUser);

        String status = this.buissnesLayer.userExist(user);

        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setStatus(status);

        return genericResponse;
    }


    //Funcion search, esta retorna una lista con las posibles coincidencias a partir del valor que ingrese
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/searchUsers/{var_buscar}")
    public List<User> searchUsers(@PathParam("var_buscar") String varSearch) throws BuisnessLayerException {
        List<User> users = this.buissnesLayer.searchUsers(varSearch);
        return users;
    }

    //Funcion search, esta retorna una lista con las posibles coincidencias a partir del valor que ingrese
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/searchById/{id}")
    public User searchById(@PathParam("id") String idUser) throws BuisnessLayerException {
        User user = new User();
        //user.setIdUser(idUser);
        return this.buissnesLayer.searchById(user);

    }


}