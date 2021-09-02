package com.kainos.ea.resources;

import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.objects.JobRole;
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
public class WebController {
    private Service webService;

    public WebController(Service webService) {
        this.webService = webService;
    }

    @GET
    @Path("/JobRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobRole> jobRoles() {
        return webService.getAllJobRoles();
    }

    @GET
    @Path("/JobSpecifications")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobRole> jobSpecifications() {
        return webService.getJobSpecifications();
    }

    @GET
    @Path("/JobCapability")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobRole> jobCapability(){
        return webService.getJobCapability();
    }

    @GET
    @Path("/BandLevels")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobRole> bandLevels(){ return webService.getBandLevels();}

}
