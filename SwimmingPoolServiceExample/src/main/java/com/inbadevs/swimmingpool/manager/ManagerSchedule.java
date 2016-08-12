/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.PaymentDao;
import com.inbadevs.swimmingpool.dao.ScheduleDao;
import com.inbadevs.swimmingpool.entities.Payment;
import com.inbadevs.swimmingpool.entities.Schedule;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManagerSchedule {

    @Autowired
    ScheduleDao schedule;

    @Autowired
    PaymentDao paymentDao;



    public List<Schedule> getAllSchedule() {
        return this.schedule.all();
    }
    
    public List<Schedule> getAllForName() {
        return this.schedule.allOrderName();
    }
    
    public void addSchedule(Schedule schedule){
        this.schedule.save(schedule);
    }
    
    public Boolean modifySchedule(Schedule schedule){

        List<Payment> paymentsPlanFilter = getPayments(schedule.getId());

        if (paymentsPlanFilter.isEmpty()) {
            this.schedule.update(schedule);
            return true;
        }
        return false;

    }


    public Boolean deleteSchedule(Long id) {
        
        
        List<Payment> paymentsPlanFilter = getPayments(id);

        if (paymentsPlanFilter.isEmpty()) {
            this.schedule.delete(id);
            return true;
        }
        return false;
        
    }

    private List<Payment> getPayments(Long id) {
        List<Payment> payments = paymentDao.all();
        List<Payment> paymentsPlanScheduleFilter = new ArrayList<>();

        for (Payment payment : payments) {
            if (payment.getProduct().getProductPK().getSchedule().getId() == id) {
                paymentsPlanScheduleFilter.add(payment);
            }
        }
        return paymentsPlanScheduleFilter;
    }


    public List<Schedule> searchScheduleRestriction(int sizeRestriction) {
        List<Schedule> schedules = this.schedule.all();

        List<Schedule> scheduleFilter = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if(schedule.getDaySection().size() == sizeRestriction) {
                scheduleFilter.add(schedule);
            }
        }

        return scheduleFilter;
    }

    public Schedule search(Long idSchedule) throws NotFoundException {
        return this.schedule.find(idSchedule);
    }
}
