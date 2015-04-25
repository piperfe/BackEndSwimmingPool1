/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.ScheduleDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerSchedule {
    @Autowired
    ScheduleDao schedule;
    
    public List<Schedule> getAllSchedule() {
        return this.schedule.all();
    }
    
    public void addSchedule(Schedule schedule){
        this.schedule.save(schedule);
    }
    
    public void modifySchedule(Schedule schedule){
        this.schedule.update(schedule);
    
    }
    
    public void deleteSchedule(Integer id){
        this.schedule.delete(id);
    
    }
}
