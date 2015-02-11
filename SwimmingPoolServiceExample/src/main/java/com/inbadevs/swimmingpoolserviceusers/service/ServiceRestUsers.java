package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.buisness.BuisnessLayer;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Path("/users")
public class ServiceRestUsers {
 
        @Autowired
        BuisnessLayer buissnesLayer;
        
        
        @GET
        @Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")
	public List<User> getAllUsers() throws BuisnessLayerException {
		List<User> users = this.buissnesLayer.getAllUsers();
                return users;
	}
        
        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	@Path("/addUser")
	public void AddUser(User user) throws BuisnessLayerException {
		this.buissnesLayer.addUser(user);
	}
        

 
}
