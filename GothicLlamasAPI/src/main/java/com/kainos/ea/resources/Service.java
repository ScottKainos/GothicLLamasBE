package com.kainos.ea.resources;

import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.jdbi.v3.core.Jdbi.*;
import java.util.List;

public class Service implements CapabilitiesAndRolesMapper {


    public Service() {

    }

    @Override
    public List<CapabilitiesAndRoles> getAllJobRoles() {
        List<CapabilitiesAndRoles> jobRoles = Jdbi.withExtension(CapabilitiesAndRolesMapper.class, mapper -> {
            mapper.getAllJobRoles();
        });
        return jobRoles;
    }
}
