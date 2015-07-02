/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.RegionDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Region;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerRegion {
    
    
    @Autowired
    RegionDao region;
    
    
    public List<Region> getAllRegions() {
        return this.region.all();
    }
    
    public Region search(Long idRegion) throws NotFoundException {
        return this.region.find(idRegion);
    }
    
}
