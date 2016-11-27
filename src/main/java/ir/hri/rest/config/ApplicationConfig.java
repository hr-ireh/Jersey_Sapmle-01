package ir.hri.rest.config;

import ir.hri.rest.controller.BaseInfo;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationConfig extends Application {
    final static Logger logger = Logger.getLogger(ApplicationConfig.class);

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        logger.info("REST configuration starting: getClasses()");

        resources.add(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
        resources.add(JsonMoxyConfigurationContextResolver.class);
        resources.add(CustomWadlGeneratorConfig.class);
        resources.add(BaseInfo.class);

        logger.info("REST configuration ended successfully.");
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();

        properties.put("jersey.config.server.wadl.disableWadl", false);

        return properties;
    }
}