package com.kainos.ea.resources;

import com.kainos.ea.DBConnection;
import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.eclipse.jetty.util.ajax.JSON;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.*;

@Path("/api")
public class WebService {
    DBConnection db = new DBConnection();

    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilitiesAndRoles> getMsg(@PathParam("msg") String message) {
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

    @GET
    @Path("/testJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> testAPI(){
//
//        if (test.size() > 0){
//            return test;
//        } else {
          return Collections.singletonList("No entries found.");
//        }

    }

}