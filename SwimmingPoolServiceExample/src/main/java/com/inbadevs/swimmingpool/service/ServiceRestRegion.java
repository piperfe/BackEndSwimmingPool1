/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Region;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerRegion;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriellopezsalinas
 */

@Service
@Path("/address/region")
public class ServiceRestRegion {
    
    @Autowired
    ManagerRegion addressManager;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Region> getAllRegions() throws BuisnessLayerException {
        List<Region> regions = this.addressManager.getAllRegions();
        return regions;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Region search(@PathParam("id") Long idRegion) throws javassist.NotFoundException {
        return this.addressManager.search(idRegion);
    }
}
