/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabriellopezsalinas
 */

@XmlRootElement
@Entity
@Table(name = "horario", schema = "Piscina")
public class Schedule implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "profesor_rut")
    private String profesorRut;

    @Column(name = "hora_inicio")
    private Time horaInicio;
    
    @Column(name = "hora_fin")
    private Time horaFin;
    
    @Column(name = "lunes")
    private Bool lunes;
    
    @Column(name = "martes")
    private Bool martes;
    
    @Column(name = "miercoles")
    private Bool miercoles;
    
    @Column(name = "jueves")
    private Bool jueves;
    
    @Column(name = "viernes")
    private Bool viernes;
    
    @Column(name = "sabado")
    private Bool sabado;
    
    @Column(name = "domingo")
    private Bool domingo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfesorRut() {
        return profesorRut;
    }

    public void setProfesorRut(String profesorRut) {
        this.profesorRut = profesorRut;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Bool getLunes() {
        return lunes;
    }

    public void setLunes(Bool lunes) {
        this.lunes = lunes;
    }

    public Bool getMartes() {
        return martes;
    }

    public void setMartes(Bool martes) {
        this.martes = martes;
    }

    public Bool getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Bool miercoles) {
        this.miercoles = miercoles;
    }

    public Bool getJueves() {
        return jueves;
    }

    public void setJueves(Bool jueves) {
        this.jueves = jueves;
    }

    public Bool getViernes() {
        return viernes;
    }

    public void setViernes(Bool viernes) {
        this.viernes = viernes;
    }

    public Bool getSabado() {
        return sabado;
    }

    public void setSabado(Bool sabado) {
        this.sabado = sabado;
    }

    public Bool getDomingo() {
        return domingo;
    }

    public void setDomingo(Bool domingo) {
        this.domingo = domingo;
    }

}