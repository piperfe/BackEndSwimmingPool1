package com.inbadevs.swimmingpoolserviceusers.service;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.GenericResponse;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.buisness.BuisnessLayer;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.service.ServiceRestUsers;
import static java.sql.Types.NULL;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        
        @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	@Path("/addUser")
	public GenericResponse AddUserPicina(User user) throws BuisnessLayerException {
		this.buissnesLayer.addUserPiscina(user);
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setIdUser(user.getIdUser());
                genericResponse.setStatus("SUCCESSFUL");
                
                return genericResponse;
	}
        
        @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	@Path("/addUserAdmin")
	public Response addUserAdmin(User user) throws BuisnessLayerException {
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
                user.setIdUser(idUser);
                user.setClave(password);
                
                GenericResponse genericResponse = this.buissnesLayer.getUser(user);
                
                return genericResponse;
        }
        
        @GET
        @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/isUserExist/{id}")
	public GenericResponse userExist(@PathParam("id") String idUser) throws BuisnessLayerException {
		User user = new User();
                user.setIdUser(idUser);
                
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
                user.setIdUser(idUser);
                return this.buissnesLayer.searchById(user);
                
	}
        
        
}