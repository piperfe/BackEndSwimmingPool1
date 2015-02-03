package com.inbadevs.swimmingpoolserviceexample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * DictionaryWord Clase que representa palabras de diccionario
 * 
 * @author RedTeam
 * 
 */
@Entity
@Table(name = "user", schema = "test")
@XmlRootElement()
public class User {

	@Id
	@Column(name = "id_user")
	private String idUser;

	@Column(name = "user_name")
	private String user_name;
        
        @Column(name = "password")
	private String password;

    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
