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
public class WebControllerTest {

    @Mock
    private Service wcService;
    private WebController wc;

    @Before
    public void setup() {
        wc = new WebController(wcService);
    }

    //US001 test cases

    @Test
    public void getAllJobRolesReturnsListFromService() {
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(wcService.getAllJobRoles()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wc.jobRoles();

        verify(wcService).getAllJobRoles();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromGetAllJobRolesPassedThrough() {
        when(wcService.getAllJobRoles()).thenThrow(new RuntimeException("Expected exception"));
        try {
            wc.jobRoles();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    //US002 test cases

    @Test
    public void jobSpecificationReturnsListFromService(){
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(wcService.getJobRoleAndSpecifications()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wc.jobSpecification();

        verify(wcService).getJobRoleAndSpecifications();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobSpecificationPassedThrough() {
        when(wcService.getJobRoleAndSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wc.jobSpecification();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    //US003 test cases

    @Test
    public void jobCapabilityReturnsListFromService() {
        var expectedList = List.of(new CapabilitiesAndRoles());
        when(wcService.getJobRoleAndCapability()).thenReturn(expectedList);

        List<CapabilitiesAndRoles> actualList = wc.jobCapability();

        verify(wcService).getJobRoleAndCapability();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobCapabilityPassedThrough() {
        when(wcService.getJobRoleAndSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wc.jobSpecification();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }


}
