package com.kainos.ea.objects;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;



public class CapabilitiesAndRolesMapper implements RowMapper<CapabilitiesAndRoles> {
    @Override
    public CapabilitiesAndRoles  map(ResultSet r, StatementContext ctx) throws SQLException
    {
        return new CapabilitiesAndRoles(r.getString("capability"), r.getString("bandLevel"),
                r.getString("jobRole"), r.getString("jobDescription"), r.getString("linkToFullDescription"));
    }
}

