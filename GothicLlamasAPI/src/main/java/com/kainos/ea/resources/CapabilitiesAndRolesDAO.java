package com.kainos.ea.resources;

import com.kainos.ea.objects.*;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface CapabilitiesAndRolesDAO {

    @SqlQuery("""
    SELECT DISTINCT 
        jobRole
    FROM capabilityAndRoles;""")
    @RegisterRowMapper(JobRolesMapper.class)
    List<JobRole> getAllJobRoles();

    @SqlQuery("""
        SELECT
            jobRole,
            jobDescription,
            linkToFullDescription
        FROM capabilityAndRoles;""")
    @RegisterRowMapper(JobSpecificationsMapper.class)
    List<JobRole> getJobSpecifications();

    @SqlQuery("""
        SELECT
            jobRole,
            capability
        FROM capabilityAndRoles;""")
    @RegisterRowMapper(JobCapabilityMapper.class)
    List<JobRole> getJobCapability();

    @SqlQuery("""
            SELECT 
                jobRole,
                bandLevel 
            FROM capabilityAndRoles ORDER BY bandLevel DESC;""")
    @RegisterRowMapper(BandLevelMapper.class)
    List<JobRole> getBandLevels();

}
