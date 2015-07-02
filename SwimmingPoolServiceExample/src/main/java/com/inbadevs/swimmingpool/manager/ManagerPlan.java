/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.PaymentDao;
import com.inbadevs.swimmingpool.dao.PlanDao;
import com.inbadevs.swimmingpool.dao.ScheduleDao;
import com.inbadevs.swimmingpool.entities.Payment;
import com.inbadevs.swimmingpool.entities.Plan;
import com.inbadevs.swimmingpool.entities.Schedule;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManagerPlan {


    @Autowired
    PlanDao plan;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    PaymentDao paymentDao;

    public List<Plan> getAllPlan() {
        return this.plan.all();
    }

    public void addPlan(Plan plan) {
        this.plan.save(plan);
    }

    public Boolean modifyPlan(Plan plan) {
        List<Schedule> schedulesPlanFilter = getSchedules(plan.getId());
        List<Payment> paymentsPlanFilter = getPayments(plan.getId());

        if (schedulesPlanFilter.size() == 0 && paymentsPlanFilter.size() == 0) {
            this.plan.update(plan);
            return true;
        }

        return false;
    }

    public Boolean deletePlan(Long id) throws BuisnessLayerException {

        List<Schedule> schedulesPlanFilter = getSchedules(id);
        List<Payment> paymentsPlanFilter = getPayments(id);

        if (schedulesPlanFilter.size() == 0 && paymentsPlanFilter.size() == 0) {
            this.plan.delete(id);
            return true;
        }

        return false;

    }

    private List<Schedule> getSchedules(Long id) {
        List<Schedule> schedules = scheduleDao.all();
        List<Schedule> schedulesPlanFilter = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getPlan().getId() == id) {
                schedulesPlanFilter.add(schedule);
            }
        }
        return schedulesPlanFilter;
    }

    private List<Payment> getPayments(Long id) {
        List<Payment> payments = paymentDao.all();
        List<Payment> paymentsPlanScheduleFilter = new ArrayList<>();

        for (Payment payment : payments) {
            if (payment.getProduct().getProductPK().getPlan().getId() == id) {
                paymentsPlanScheduleFilter.add(payment);
            }
        }
        return paymentsPlanScheduleFilter;
    }


    public Plan search(Long idPlan) throws NotFoundException {
        return this.plan.find(idPlan);
    }

    public List<Plan> findAllPlanByTypeOfPlan(String typeOfPlan){
        return plan.findAllPlanByTypeOfPlan(typeOfPlan);
    }
}
