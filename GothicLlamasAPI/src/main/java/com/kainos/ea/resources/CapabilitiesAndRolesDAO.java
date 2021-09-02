package com.kainos.ea.resources;

import com.kainos.ea.objects.*;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface CapabilitiesAndRolesDAO {

    @SqlQuery("SELECT DISTINCT jobRole FROM capabilityAndRoles;")
    @RegisterRowMapper(JobRoleMapper.class)
    List<CapabilitiesAndRoles> getAllJobRoles();


    @SqlQuery("SELECT jobRole, jobDescription, linkToFullDescription FROM capabilityAndRoles;")
    @RegisterRowMapper(JobRolesAndSpecificationMapper.class)
    List<CapabilitiesAndRoles> getJobRoleAndSpecifications();

    @SqlQuery("SELECT jobRole, capability FROM capabilityAndRoles;")
    @RegisterRowMapper(JobRoleAndCapabilityMapper.class)
    List<CapabilitiesAndRoles> getJobRoleAndCapability();

}

