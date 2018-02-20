package com.mainpackage.application;

import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {
    private final ApplicationConfiguration config;
    private final Environment environment;

    public ApplicationBinder(ApplicationConfiguration config, Environment environment) {
        this.config = config;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(this.config).to(Configuration.class);
        bind(this.environment).to(Environment.class);
    }
}
