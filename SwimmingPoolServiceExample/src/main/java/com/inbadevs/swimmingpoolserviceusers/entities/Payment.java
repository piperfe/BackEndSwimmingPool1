/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabriellopezsalinas
 */
    
@XmlRootElement
@Entity
@Table(name = "pago", schema = "Piscina")
public class Payment implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "plan_id")
    private Time planId;
    
    @Column(name = "fecha")
    private Time fecha;
    
    @Column(name = "numero_boleta")
    private Time numeroBoleta;
    
    @Column(name = "monto")
    private Time monto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Time getPlanId() {
        return planId;
    }

    public void setPlanId(Time planId) {
        this.planId = planId;
    }

    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }

    public Time getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(Time numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public Time getMonto() {
        return monto;
    }

    public void setMonto(Time monto) {
        this.monto = monto;
    }
}