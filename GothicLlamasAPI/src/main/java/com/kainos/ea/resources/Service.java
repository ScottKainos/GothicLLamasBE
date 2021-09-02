package com.kainos.ea.resources;

import com.kainos.ea.objects.JobRole;

import java.util.List;

public class Service {
    private CapabilitiesAndRolesDAO dao;

    public Service(CapabilitiesAndRolesDAO dao) {
        this.dao = dao;
    }

    public List<JobRole> getAllJobRoles() {
        return dao.getAllJobRoles();
    }

    public List<JobRole> getJobSpecifications() {
        return dao.getJobSpecifications();
    }

    public List<JobRole> getJobCapability(){ return dao.getJobCapability(); }

    public List<JobRole> getBandLevels(){ return dao.getBandLevels(); }
}