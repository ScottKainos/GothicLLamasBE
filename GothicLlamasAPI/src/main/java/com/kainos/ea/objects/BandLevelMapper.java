package com.kainos.ea.objects;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BandLevelMapper implements RowMapper<JobRole> {
    @Override
    public JobRole map(ResultSet r, StatementContext ctx) throws SQLException {
        JobRole cap = new JobRole();
        cap.setJobRole(r.getString("jobRole"));
        cap.setBandLevel(r.getString("bandLevel"));
        return cap;
    }
}