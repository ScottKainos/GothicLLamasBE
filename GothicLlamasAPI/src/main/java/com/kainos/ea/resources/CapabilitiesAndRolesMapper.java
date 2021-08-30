package com.kainos.ea.resources;

import com.kainos.ea.DBConnection;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface CapabilitiesAndRolesMapper {

    @SqlQuery("SELECT DISTINCT jobRole AS \"Job Role\" FROM capabilityAndRoles")
    List<CapabilitiesAndRoles> getAllJobRoles();

}

