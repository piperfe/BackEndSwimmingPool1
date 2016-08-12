/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gabriellopezsalinas
 */

@Entity
@Getter

public class HistoryConnection implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String dateConnection;
    
    //private String dateDisConnection;
    
    @ManyToOne
    private User user;
    
    public HistoryConnection(){
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dateConnection = dateFormat.format(sumarMinutos(sumarRestarHorasFecha(new Date(),-3),-7));
    }

    public Date sumarRestarHorasFecha(Date fecha, int horas){	
      Calendar calendar = Calendar.getInstance();	
      calendar.setTime(fecha); // Configuramos la fecha que se recibe	
      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
	
      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
    }
    
    public Date sumarMinutos(Date fecha, int minutos){	
      Calendar calendar = Calendar.getInstance();	
      calendar.setTime(fecha); // Configuramos la fecha que se recibe	
      calendar.add(Calendar.MINUTE, minutos);  // numero de horas a añadir, o restar en caso de horas<0
	
      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}
