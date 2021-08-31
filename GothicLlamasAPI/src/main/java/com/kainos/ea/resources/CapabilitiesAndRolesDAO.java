package com.kainos.ea.resources;

import com.kainos.ea.DBConnection;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import com.kainos.ea.objects.CapabilitiesAndRolesMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RegisterRowMapper(CapabilitiesAndRolesMapper.class)
public interface CapabilitiesAndRolesDAO {

    @SqlQuery("SELECT DISTINCT jobRole AS \"Job Role\" FROM capabilityAndRoles;")
    List<CapabilitiesAndRoles> getAllJobRoles();

}

