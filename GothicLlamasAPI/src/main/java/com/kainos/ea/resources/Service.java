package com.kainos.ea.resources;

import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import io.dropwizard.jdbi3.*;
import java.util.List;

public class Service {
    private CapabilitiesAndRolesMapper dao;

    public Service(CapabilitiesAndRolesMapper dao) {
        this.dao = dao;
    }

    public List<CapabilitiesAndRoles> getAllJobRoles() {
        return dao.getAllJobRoles();
//        final CapabilitiesAndRolesMapper dao = jdbi.onDemand(CapabilitiesAndRolesMapper.class);
//        List<CapabilitiesAndRoles> jobRoles = dao.getAllJobRoles();
//        return jobRoles;
    }
}
