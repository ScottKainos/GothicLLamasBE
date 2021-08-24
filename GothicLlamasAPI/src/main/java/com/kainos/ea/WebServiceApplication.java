package com.kainos.ea;

import com.kainos.ea.resources.WebService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi3.*;
import com.kainos.ea.resources.*;
import org.jdbi.v3.core.Jdbi;
import com.kainos.ea.DBConnection;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class WebServiceApplication extends Application<WebServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "WebService";
    }

    @Override
    public void initialize(final Bootstrap<WebServiceConfiguration> bootstrap) {}

    @Override
    public void run(final WebServiceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        environment.jersey().register(new WebService());
    }
}


