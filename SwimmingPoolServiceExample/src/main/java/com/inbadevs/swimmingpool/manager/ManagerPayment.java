/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.PaymentDao;
import com.inbadevs.swimmingpool.entities.Payment;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerPayment {
    
    @Autowired
    PaymentDao payment;
    
    public List<Payment> getAllPayment() {
        return this.payment.all();
    }
    
    public List<Payment> closeTurn(Long idUserAdmin) {
        List<Payment> payments = this.payment.closeTurn(idUserAdmin);
        return payments;
    }
    
    public void addPayment(Payment payment){
        this.payment.save(payment);
    }
    
    public void modifyPayment(Payment payment){
        this.payment.update(payment);
    
    }

    public void deletePayment(Long id) throws BuisnessLayerException {
        this.payment.delete(id);
    }
   

    public List<Payment> getPaymentsBySwimmingPoolUser(Long swimmingPoolUserId) {
        List<Payment> payments = this.payment.getPaymentsBySwimmingPoolUser(swimmingPoolUserId);
        return payments;
    }
    
    public List<Payment> getPaymentsActiveBySwimmingPoolUser(Long swimmingPoolUserId) {
        List<Payment> payments = this.payment.getPaymentsActiveBySwimmingPoolUser(swimmingPoolUserId);
        return payments;
    }

    public Payment getPaymentsByNumberOfTicket(String numberOfTicket) {
        return this.payment.findBy("numberOfTicket", numberOfTicket);
    }

    public Payment getPaymentsById(Long paymentId) throws NotFoundException {
        return this.payment.find(paymentId);
    }
}
