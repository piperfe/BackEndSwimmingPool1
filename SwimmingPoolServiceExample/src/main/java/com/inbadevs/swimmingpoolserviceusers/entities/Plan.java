/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

/**
 *
 * @author gabriellopezsalinas
 */

@XmlRootElement
@Entity
@Getter

public class Plan implements Serializable {
   
    @Id
    private String id;
    
    private String name;
    
    private String description;
    
    @ManyToOne
    private Schedule schedule;
   
}



/*
CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `id_schedule` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_schedule_idx` (`id_schedule`),
  CONSTRAINT `id_schedule` FOREIGN KEY (`id_schedule`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
*/