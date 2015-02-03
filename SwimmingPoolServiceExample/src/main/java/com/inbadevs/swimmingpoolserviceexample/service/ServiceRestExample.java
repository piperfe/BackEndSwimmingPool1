package com.inbadevs.swimmingpoolserviceexample.service;

import com.inbadevs.swimmingpoolserviceexample.dao.UserDao;
import com.inbadevs.swimmingpoolserviceexample.entities.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Path("/hello")
public class ServiceRestExample {
 
        @Autowired
        UserDao users;
        
      
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
        
        @GET
        @Produces({MediaType.APPLICATION_JSON })
	@Path("/exampleBd/ex")
	public List<User> getBdInfo() throws Exception {
		return users.getAllUsers();
	}
 
}
