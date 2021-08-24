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

        try (var f = new FileInputStream("/Users/ciaran.mullan/git/GothicLlamasAPI/src/main/java/com/kainos/ea/db.properties")) {
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

    public ResultSet QueryDatabase() {
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT capability, bandLevel, jobRole, jobDescription, linkToFullDescription FROM capabilityAndRoles limit 5");
//            while (rs.next()) {
//                System.out.println(rs.getString("capability"));
//            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
