package com.kainos.ea.resources;

import com.kainos.ea.DBConnection;
import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.*;

@Path("/gothicLlamas")
public class WebService {
    DBConnection db = new DBConnection();

    @GET
    @Path("/jobRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilitiesAndRoles> getMsg() {
        try {
            System.out.println("poc achieved!");
            ResultSet testRS = db.QueryDatabase();
            List<CapabilitiesAndRoles> jsonArray = new ArrayList<CapabilitiesAndRoles>();
            while (testRS.next()) {
                int columns = testRS.getMetaData().getColumnCount();
                CapabilitiesAndRoles obj = new CapabilitiesAndRoles();
                //collect job rol into object
                obj.setJobRole(testRS.getString("Job Role"));
                jsonArray.add(obj);
            }
            System.out.println(jsonArray);
            return jsonArray;
        } catch (Exception e) {
            return null;
        }
    }

    public DBConnection getDb() {
        return db;
    }
}