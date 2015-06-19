/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.PaymentDao;
import com.inbadevs.swimmingpoolserviceusers.dao.ScheduleDao;
import com.inbadevs.swimmingpoolserviceusers.entities.Payment;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerSchedule {

    @Autowired
    ScheduleDao schedule;

    @Autowired
    PaymentDao paymentDao;



    public List<Schedule> getAllSchedule() {
        return this.schedule.all();
    }
    
    public void addSchedule(Schedule schedule){
        this.schedule.save(schedule);
    }
    
    public Boolean modifySchedule(Schedule schedule){

        List<Payment> paymentsPlanFilter = getPayments(schedule.getId());

        if (paymentsPlanFilter.size() == 0) {
            this.schedule.update(schedule);
            return true;
        }
        return false;

    }


    public Boolean deleteSchedule(Long id) throws BuisnessLayerException {

        List<Payment> paymentsPlanFilter = getPayments(id);

        if (paymentsPlanFilter.size() == 0) {
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
