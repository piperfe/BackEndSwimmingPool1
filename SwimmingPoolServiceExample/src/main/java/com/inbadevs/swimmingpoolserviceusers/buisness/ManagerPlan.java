/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.PlanDao;
import com.inbadevs.swimmingpoolserviceusers.dao.ScheduleDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Plan;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gabriellopezsalinas
 */

@Component
public class ManagerPlan {


    @Autowired
    PlanDao plan;

    @Autowired
    ScheduleDao scheduleDao;

    public List<Plan> getAllPlan() {
        return this.plan.all();
    }

    public void addPlan(Plan plan) {
        this.plan.save(plan);
    }

    public void modifyPlan(Plan plan) {
        this.plan.update(plan);
    }

    public List<Schedule> deletePlan(Long id) throws BuisnessLayerException {

        List<Schedule> schedules = scheduleDao.all();
        List<Schedule> schedulesPlanFilter = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getPlan().getId() == id) {
                schedulesPlanFilter.add(schedule);
            }
        }

        if (schedulesPlanFilter.size() == 0) {
            this.plan.delete(id);
        }

        return schedulesPlanFilter;

    }

    public Plan search(Long idPlan) throws NotFoundException {
        return this.plan.find(idPlan);
    }
}
