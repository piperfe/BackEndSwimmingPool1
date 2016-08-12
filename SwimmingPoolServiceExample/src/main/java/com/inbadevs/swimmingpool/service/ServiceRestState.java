/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.State;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerState;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriellopezsalinas
 */


@Service
@Path("/state")
public class ServiceRestState {
    
    @Autowired
    ManagerState stateManager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public List<State> getAllState() throws BuisnessLayerException{
        return this.stateManager.getAllState();
    }
    
    
}
