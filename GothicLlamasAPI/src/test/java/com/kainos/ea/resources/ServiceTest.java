package com.kainos.ea.resources;

import com.kainos.ea.objects.JobRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    private Service wcService;
    @Mock
    private CapabilitiesAndRolesDAO dao;

    @Before
    public void setup() {
        wcService = new Service(dao);
    }

    @Test
    public void getAllJobRolesReturnsListFromDAO() {
        var expectedList = List.of(new JobRole());
        when(dao.getAllJobRoles()).thenReturn(expectedList);

        List<JobRole> actualList = wcService.getAllJobRoles();

        verify(dao).getAllJobRoles();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromGetAllJobRolesPassedThrough() {
        when(dao.getAllJobRoles()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wcService.getAllJobRoles();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    @Test
    public void getJobSpecificationsReturnsListFromDAO() {
        var expectedList = List.of(new JobRole());
        when(dao.getJobSpecifications()).thenReturn(expectedList);

        List<JobRole> actualList = wcService.getJobSpecifications();

        verify(dao).getJobSpecifications();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void exceptionFromGetJobSpecificationsPassedThrough() {
        when(dao.getJobSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try {
            wcService.getJobSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    @Test
    public void jobCapabilityReturnsListFromService() {
        var expectedList = List.of(new JobRole());
        when(dao.getJobCapability()).thenReturn(expectedList);

        List<JobRole> actualList = wcService.getJobCapability();

        verify(dao).getJobCapability();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobCapabilityPassedThrough() {
        when(dao.getJobSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wcService.getJobSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

}
