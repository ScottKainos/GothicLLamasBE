package com.kainos.ea.objects;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRoleAndCapabilityMapper implements RowMapper<CapabilitiesAndRoles> {
    @Override
    public CapabilitiesAndRoles map(ResultSet r, StatementContext ctx) throws SQLException {
        CapabilitiesAndRoles cap = new CapabilitiesAndRoles();
        cap.setJobRole(r.getString("Job Role"));
        cap.setCapability(r.getString("Capability"));
        return cap;
    }
}
