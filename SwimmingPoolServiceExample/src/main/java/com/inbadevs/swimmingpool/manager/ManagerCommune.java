/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.CommuneDao;
import com.inbadevs.swimmingpool.entities.Commune;

import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerCommune {
    
    @Autowired
    CommuneDao commune;
    
    
    public List<Commune> getAllCommunes() {
        return this.commune.all();
    }
    
    public Commune search(Long idCommune) throws NotFoundException {
        return this.commune.find(idCommune);
    }
    
    public List<Commune> findAllCommuneByIdRegion(Long idRegion) throws NotFoundException {
        return this.commune.findAllCommuneByIdRegion(idRegion);
    }
}
