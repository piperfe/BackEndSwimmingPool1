/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

/**
 *
 * @author gabriellopezsalinas
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "usuario_piscina", schema = "Piscina")
public class SwimingPoolUser implements Serializable{
    
    @Id
    @Column(name = "rut_usuario")
    private String idUser;
    
    @Column(name = "certificado_medico")
    private String certificadoMedico;
    
    @Column(name = "enfermedades")
    private String enfermedades;
    
    @Column(name = "observaciones")
    private String observaciones;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String isCertificadoMedico() {
        return certificadoMedico;
    }

    public void setCertificadoMedico(String certificadoMedico) {
        this.certificadoMedico = certificadoMedico;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
