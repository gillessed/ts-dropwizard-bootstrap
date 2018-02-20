package com.mainpackage.application;

import com.mainpackage.api.FooResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ApplicationMain extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception {
        new ApplicationMain().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/static", "/", "index.html"));
    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        new ApplicationBinder(configuration, environment);
        environment.jersey().register(FooResource.class);
    }
}
