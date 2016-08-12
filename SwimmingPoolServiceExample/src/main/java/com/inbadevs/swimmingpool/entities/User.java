package com.inbadevs.swimmingpool.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import javafx.scene.text.Text;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
   
    @ManyToOne
    private Commune commune;
    
    @Column(unique = true)
    private String rut;

    private String names;

    private String firstLastName;

    private String secondLastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String birthDate;

    private String address;
    
    @Setter
    private String password;
   
    private String email;

    private String phone;
    
    private String phoneMobile;
    
    @Column(columnDefinition="TEXT")
    private String fingerPrint;

    @Setter
    private int profile;

    public void setNames(String names) {
        this.names = names.toUpperCase();
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName.toUpperCase();
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName.toUpperCase();
    }

    public void setAddress(String address) {
        this.address = address.toUpperCase();
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }


}