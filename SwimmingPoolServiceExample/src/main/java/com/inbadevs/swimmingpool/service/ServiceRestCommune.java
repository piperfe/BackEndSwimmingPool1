/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.entities.Commune;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpool.manager.ManagerCommune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author gabriellopezsalinas
 */

@Service
@Path("address/commune")
public class ServiceRestCommune {
    
    @Autowired
    ManagerCommune communeManager;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public List<Commune> getAllCommunes() throws BuisnessLayerException {
        List<Commune> commune = this.communeManager.getAllCommunes();
        return commune;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Commune search(@PathParam("id") Long idCommune) throws javassist.NotFoundException {
        return this.communeManager.search(idCommune);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAllCommuneByIdRegion/{id}")
    public List<Commune> findAllCommuneByIdRegion(@PathParam("id") Long idRegion) throws javassist.NotFoundException {
        List<Commune> commune = this.communeManager.findAllCommuneByIdRegion(idRegion);
        return commune;
    }
}