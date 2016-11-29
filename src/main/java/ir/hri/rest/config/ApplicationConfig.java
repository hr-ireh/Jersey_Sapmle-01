package ir.hri.rest.config;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    final static Logger logger = Logger.getLogger(ApplicationConfig.class);

    public ApplicationConfig() {
        logger.info("REST configuration starting: getClasses()");

        packages("ir.hri.rest.controller");
        register(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
        register(JsonMoxyConfigurationContextResolver.class);
        register(CustomWadlGeneratorConfig.class);
        property("jersey.config.server.wadl.disableWadl", false);

        logger.info("REST configuration ended successfully.");
    }
}