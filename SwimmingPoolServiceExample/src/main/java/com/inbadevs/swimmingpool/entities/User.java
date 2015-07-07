package com.inbadevs.swimmingpool.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
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

    @Setter
    private int profile;

}