package com.kainos.ea.objects;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobCapabilityMapper implements RowMapper<JobRole> {
    @Override
    public JobRole map(ResultSet r, StatementContext ctx) throws SQLException {
        JobRole cap = new JobRole();
        cap.setJobRole(r.getString("jobRole"));
        cap.setCapability(r.getString("capability"));
        return cap;
    }
}

