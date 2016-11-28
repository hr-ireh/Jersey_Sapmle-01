package ir.hri.rest.config;


import org.glassfish.jersey.server.wadl.config.WadlGeneratorConfig;
import org.glassfish.jersey.server.wadl.internal.generators.WadlGeneratorApplicationDoc;

import java.util.List;

public class CustomWadlGeneratorConfig extends WadlGeneratorConfig {
    @Override
    public List configure() {
        return generator(WadlGeneratorApplicationDoc.class)
                .descriptions();
    }
}