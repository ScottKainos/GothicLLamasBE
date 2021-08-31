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
    }

    public List<CapabilitiesAndRoles> getJobRoleAndSpecifications() {
        return dao.getJobRoleAndSpecifications();
    }

    public List<CapabilitiesAndRoles> getJobRoleAndCapability(){
        return dao.getJobRoleAndCapability();
    }


}
