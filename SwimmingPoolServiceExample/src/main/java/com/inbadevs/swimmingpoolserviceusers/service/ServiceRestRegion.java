/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.service;

import com.inbadevs.swimmingpoolserviceusers.buisness.ManagerRegion;
import com.inbadevs.swimmingpoolserviceusers.entities.Region;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
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
