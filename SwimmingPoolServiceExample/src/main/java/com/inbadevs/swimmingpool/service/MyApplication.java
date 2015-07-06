package com.inbadevs.swimmingpool.service;

import com.inbadevs.swimmingpool.service.serializers.JacksonConfig;
import com.inbadevs.swimmingpoolserviceusers.service.ServiceRestCommune;
import com.inbadevs.swimmingpoolserviceusers.service.ServiceRestRegion;
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
    public MyApplication() {
        register(RequestContextFilter.class);
        register(ServiceRestUsers.class);
        register(ServiceRestPlan.class);
        register(ServiceRestSchedule.class);
        register(ServiceRestSwimmingPoolUsers.class);
        register(ServiceRestAdminUsers.class);
        register(ServiceRestPayment.class);
        register(ServiceRestCommune.class);
        register(ServiceRestRegion.class);
        register(JacksonFeature.class);        
        register(ServiceRestAccessControl.class);
        registerClasses(JacksonConfig.class);
        register(JacksonFeature.class);
    }

}
