package com.inbadevs.swimmingpool.manager.controlAccess;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by macbook on 8/8/15.
 */
@Component
public class ControlAccessFactory {


    public static final String TYPE_HOURS_PER_WEEK = "typeHoursPerWeek";
    public static final String TYPE_BLOCKS_PER_WEEK = "typeBlocksPerWeek";

    @Autowired
    @Setter
    private ApplicationContext context;


    public Access getControlAccess(String typeOfPlan){

        if(typeOfPlan.equals(TYPE_HOURS_PER_WEEK)){

            return context.getBean("freeHoursAccess", Access.class);
        }
        else if (typeOfPlan.equals(TYPE_BLOCKS_PER_WEEK)) {

            return context.getBean("scheduleAccess", Access.class);
        }

        return null;

    }

}
