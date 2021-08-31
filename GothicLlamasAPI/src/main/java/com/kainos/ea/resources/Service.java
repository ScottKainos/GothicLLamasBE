package com.kainos.ea.resources;

import com.kainos.ea.objects.CapabilitiesAndRoles;

import java.util.List;

public class Service {
    private CapabilitiesAndRolesDAO dao;

    public Service(CapabilitiesAndRolesDAO dao) {
        this.dao = dao;
    }

    public List<CapabilitiesAndRoles> getAllJobRoles() {
        return dao.getAllJobRoles();
//        final CapabilitiesAndRolesMapper dao = jdbi.onDemand(CapabilitiesAndRolesMapper.class);
//        List<CapabilitiesAndRoles> jobRoles = dao.getAllJobRoles();
//        return jobRoles;
    }
}
