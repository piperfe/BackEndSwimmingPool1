package com.inbadevs.swimmingpool.service.serializers;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig   implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonConfig() {
        objectMapper = new ObjectMapper();

        SerializationConfig serConfig = objectMapper.getSerializationConfig();
        serConfig.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));

        DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
        deserializationConfig.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));

        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}



