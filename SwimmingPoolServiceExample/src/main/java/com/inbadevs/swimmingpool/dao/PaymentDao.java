/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.dao;

import com.inbadevs.swimmingpool.entities.Payment;
import java.text.ParseException;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


@Component
public class PaymentDao extends BaseGenericDAO<Payment>{
    
    @Autowired
    public PaymentDao(@Qualifier("sessionFactory") SessionFactory em) {
        super(Payment.class, em);
    }

    public static Date ParseFecha(String fecha)
    {
        fecha=fecha.replace('-','/');
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public List<Payment> closeTurn(Long idUserAdmin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String query1 = "from Payment where admin_user = "+idUserAdmin+" AND STR_TO_DATE(datepay, '%d/%m/%Y') = STR_TO_DATE('"+dateFormat.format(new Date())+"', '%d/%m/%Y')";
        Query query = getCurrentSession().createQuery(query1);
        List<Payment> lista = query.list();   
        
        return lista;
        

    }

    public List<Payment> salesReportBetweenDates(String dateStart, String dateEnd) throws ParseException {
        Date dtStart = ParseFecha(dateStart);
        Date dtEnd = ParseFecha(dateEnd);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicial =dateFormat.format(dtStart);
        String fechaFinal = dateFormat.format(dtEnd);
        String query1 = "from Payment where STR_TO_DATE(datepay, '%d/%m/%Y') between STR_TO_DATE('"+fechaInicial+"', '%d/%m/%Y') and STR_TO_DATE('"+fechaFinal+"', '%d/%m/%Y') ORDER BY datepay";
        
       Query query = getCurrentSession().createQuery(query1);
       List<Payment> lista = query.list();   
        
        return lista;

    }
    
    public List<Payment> getPaymentsBySwimmingPoolUser(Long swimmingPoolUserId) {

        Criteria criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("swimmingPoolUser", FetchMode.JOIN)
                .add(Restrictions.eq("swimmingPoolUser.id", swimmingPoolUserId));
        return criteria.list();

    }
    
    
    public List<Payment> getPaymentsActiveBySwimmingPoolUser(Long swimmingPoolUserId) {

        Criteria criteria;
        criteria = getCurrentSession().createCriteria(Payment.class).
                setFetchMode("swimmingPoolUser", FetchMode.JOIN)
                .add(Restrictions.eq("swimmingPoolUser.id", swimmingPoolUserId))
                //setFetchMode("product", FetchMode.JOIN).
                .add(Restrictions.eqProperty("product.id","product" ))
                .add(Restrictions.ge("product.startValidDate", (new SimpleDateFormat("dd/MM/yyy")).toString()))
                .add(Restrictions.le("product.endValidDate", (new SimpleDateFormat("dd/MM/yyy")).toString()))
               ;
        return criteria.list();

    }


}
