package com.kainos.ea;

import com.kainos.ea.resources.WebService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi3.*;
import com.kainos.ea.resources.*;
import org.jdbi.v3.core.Jdbi;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class WebServiceApplication extends Application<WebServiceConfiguration> {

    Connection c = DBConnection();

    public Connection getC() {
        return c;
    }

    public static void main(final String[] args) throws Exception {
        new WebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "WebService";
    }

    @Override
    public void initialize(final Bootstrap<WebServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final WebServiceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        environment.jersey().register(new WebService());
    }

    public Connection DBConnection(){
        String user;
        String password;
        String host;

        try (var f = new FileInputStream("/Users/ciaran.mullan/git/GothicLlamasAPI/src/main/java/com/kainos/ea/db.properties")){
            Properties props = new Properties();
            props.load(f);
            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain user, " +
                                "password, and host properties.");
            c = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/GothicLlamasDB", user, password);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT capability FROM capabilityAndRoles limit 5");
            while (rs.next()) {
                System.out.println(rs.getString("capability"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }



}


