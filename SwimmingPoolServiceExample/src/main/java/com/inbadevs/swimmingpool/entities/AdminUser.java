package com.inbadevs.swimmingpool.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import javafx.scene.text.Text;


@Entity
@Getter
@NoArgsConstructor
public class AdminUser extends User implements Serializable {

    private String position;

    public AdminUser(Long id, Commune commune, String rut, String names, String firstLastName, String secondLastName, String birthDate, String address, String password, String email, String phone, String phoneMobile, String fingerPrint, int profile) {
        super(id, commune, rut, names, firstLastName, secondLastName, birthDate, address, password, email, phone, phoneMobile, fingerPrint, profile);
    }
}
