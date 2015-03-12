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
@Table(name = "plan", schema = "Piscina")
public class Plan implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "horario_id")
    private String horarioId;

    @Column(name = "nombre")
    private Time nombre;
    
    @Column(name = "descripcion")
    private Time descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String horarioId) {
        this.horarioId = horarioId;
    }

    public Time getNombre() {
        return nombre;
    }

    public void setNombre(Time nombre) {
        this.nombre = nombre;
    }

    public Time getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Time descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
