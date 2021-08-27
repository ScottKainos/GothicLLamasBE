package com.kainos.ea;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection c;

    public DBConnection() {
        connect();
    }

    public static void connect() {
        String user;
        String password;
        String host;

        try (var f = new FileInputStream("db.properties")) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet U001() {
        try {
            Statement st = c.createStatement();
            //select all distinct job roles within kainos from the database
            return st.executeQuery("SELECT DISTINCT jobRole AS \"Job Role\" FROM capabilityAndRoles");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet customQuery(String query) {
        try {
            Statement st = c.createStatement();
            //select all distinct job roles within kainos from the database
            return st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet U002() {
        try {
            Statement st = c.createStatement();
            //select all distinct job roles within kainos from the database
            return st.executeQuery("SELECT jobRole AS \"Job Role\", jobDescription AS \"Job description\", linkToFullDescription AS \"Link to SharePoint\" FROM capabilityAndRoles;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
