package com.inbadevs.swimmingpoolserviceusers.service;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
 
/**
 * Registers the components to be used by the JAX-RS application  
 * 
 * @author InbaDevs
 *
 */
public class MyApplication extends ResourceConfig {
 
    /**
    * Register JAX-RS application components.
    */    
    public MyApplication(){
        register(RequestContextFilter.class);
        register(ServiceRestUsers.class);
        register(ServiceRestPlan.class);
        register(ServiceRestSchedule.class);
        register(ServiceRestAssistance.class);
        register(ServiceRestSwimmingPoolUsers.class);
        register(ServiceRestAdminUsers.class);
        register(ServiceRestPayment.class);
        register(JacksonFeature.class);        
    }
}
