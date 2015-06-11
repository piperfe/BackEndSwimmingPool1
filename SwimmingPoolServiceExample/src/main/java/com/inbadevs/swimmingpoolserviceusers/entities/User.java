package com.inbadevs.swimmingpoolserviceusers.entities;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String rut;

    private String names;

    private String firstLastName;

    private String secondLastName;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;

    private String address;
    
    private String state;
    
    private String password;
   
    private String email;

    private String phone;
    
    private int id_profile=1;

}