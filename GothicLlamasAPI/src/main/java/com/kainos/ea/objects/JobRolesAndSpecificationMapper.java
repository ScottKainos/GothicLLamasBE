package com.kainos.ea.objects;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRolesAndSpecificationMapper implements RowMapper<CapabilitiesAndRoles> {

    @Override
    public CapabilitiesAndRoles  map(ResultSet r, StatementContext ctx) throws SQLException
    {
        CapabilitiesAndRoles cap = new CapabilitiesAndRoles();
        try {
            cap.setCapability(r.getString("capability"));
        } catch (SQLException e) {
            if (!e.getMessage().equals("Column 'capability' not found.")) {
                e.printStackTrace();
            }
        }
        try {
            cap.setBandLevel(r.getString("bandLevel"));
        } catch (SQLException e) {

        }
        try {
            cap.setJobRole(r.getString("jobRole"));
        } catch (SQLException e) {

        }
        try {
            cap.setJobDescription(r.getString("jobDescription"));
        } catch (SQLException e) {

        }
        try {
            cap.setLinkToFullDescription(r.getString("linkToFullDescription"));
        } catch (SQLException e) {

        }
        return cap;
    }
}
