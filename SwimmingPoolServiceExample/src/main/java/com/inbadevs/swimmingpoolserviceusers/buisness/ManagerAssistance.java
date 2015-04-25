/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.AssistanceDao;
import com.inbadevs.swimmingpoolserviceusers.dao.PlanDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Assistance;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class ManagerAssistance {
    
    @Autowired
    AssistanceDao assistance;
    
    
    public List<Assistance> getAllAssistance() {
        return this.assistance.all();
    }
    
    public void addAssistance(Assistance assistance){
        this.assistance.save(assistance);
    }
}
