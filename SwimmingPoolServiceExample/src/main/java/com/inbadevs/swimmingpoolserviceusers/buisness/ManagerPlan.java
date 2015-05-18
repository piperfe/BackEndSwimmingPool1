/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.PlanDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class ManagerPlan {
    
    
    @Autowired
    PlanDao plan;
    
    public List<Plan> getAllPlan() {
        return this.plan.all();
    }
    
    public void addPlan(Plan plan){
        this.plan.save(plan);
    }
    
    public void modifyPlan(Plan plan){
        this.plan.update(plan);
    }

    public void deletePlan(Integer id) throws BuisnessLayerException {
        this.plan.delete(id);
    }
    

    
    
}
