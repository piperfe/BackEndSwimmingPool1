/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.StateDao;
import com.inbadevs.swimmingpool.entities.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class ManagerState {
    
    
    @Autowired
    StateDao state;
    
    public List<State> getAllState() {
        return this.state.all();
    }
}
