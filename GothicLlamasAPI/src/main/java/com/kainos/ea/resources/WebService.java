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
    @Path("/JobRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilitiesAndRoles> JobRoles(){
        try {
            ResultSet testRS = db.SelectJobRole();
            List<CapabilitiesAndRoles> jsonArray = new ArrayList<CapabilitiesAndRoles>();
            while (testRS.next()) {
                int columns = testRS.getMetaData().getColumnCount();
                CapabilitiesAndRoles obj = new CapabilitiesAndRoles();
                //collect job role into object
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
    @Path("/JobSpecifications")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilitiesAndRoles> JobSpecifications(){
        try {
            ResultSet testRS = db.SelectJobRoleAndDescription();
            List<CapabilitiesAndRoles> jsonArray = new ArrayList<CapabilitiesAndRoles>();
            while (testRS.next()) {
                int columns = testRS.getMetaData().getColumnCount();
                CapabilitiesAndRoles obj = new CapabilitiesAndRoles();
                //collect job role into object
                obj.setJobRole(testRS.getString("Job Role"));
                obj.setJobDescription(testRS.getString("Job Description"));
                obj.setLinkToFullDescription(testRS.getString("Link to SharePoint"));
                jsonArray.add(obj);
            }
            System.out.println(jsonArray);
            return jsonArray;
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Path("/JobCapability")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilitiesAndRoles> JobCapability(){
        try {
            ResultSet testRS = db.SelectJobRoleAndCapability();
            List<CapabilitiesAndRoles> jsonArray = new ArrayList<CapabilitiesAndRoles>();
            while (testRS.next()) {
                int columns = testRS.getMetaData().getColumnCount();
                CapabilitiesAndRoles obj = new CapabilitiesAndRoles();
                //collect job role into object
                obj.setJobRole(testRS.getString("Job Role"));
                obj.setCapability(testRS.getString("Capability"));
                jsonArray.add(obj);
            }
            System.out.println(jsonArray);
            return jsonArray;
        } catch (Exception e) {
            return null;
        }
    }

}