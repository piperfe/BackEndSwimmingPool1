/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class SwimmingPoolUser extends User implements Serializable{

    private String medicalCertificate;

    private String sickness;

    private String comments;

    public SwimmingPoolUser(Long id, Commune commune, String rut, String names, String firstLastName, String secondLastName, String birthDate, String address, String password, String email, String phone, String phoneMobile, int profile) {
        super(id, commune, rut, names, firstLastName, secondLastName, birthDate, address, password, email, phone, phoneMobile, profile);
    }
}
