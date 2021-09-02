package com.kainos.ea.resources;

import com.kainos.ea.objects.CapabilitiesAndRoles;
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
    private CapabilitiesAndRolesDAO dao;

    @Before
    public void setup() {
        dao = mock(CapabilitiesAndRolesDAO.class);
        wcService = new Service(dao);
    }

    @Test
    public void getAllJobRolesReturnsListFromDAO() {
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(dao.getAllJobRoles()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wcService.getAllJobRoles();

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
    public void getJobRoleAndSpecificationsReturnsListFromDAO() {
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(dao.getJobRoleAndSpecifications()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wcService.getJobRoleAndSpecifications();

        verify(dao).getJobRoleAndSpecifications();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void exceptionFromGetJobRoleAndSpecificationsPassedThrough() {
        when(dao.getJobRoleAndSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try {
            wcService.getJobRoleAndSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    @Test
    public void jobCapabilityReturnsListFromService() {
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(dao.getJobRoleAndCapability()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wcService.getJobRoleAndCapability();

        verify(dao).getJobRoleAndCapability();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobCapabilityPassedThrough() {
        when(dao.getJobRoleAndSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wcService.getJobRoleAndSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

}
