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
public class WebControllerTest {

    @Mock
    private Service wcService;
    private WebController wc;

    @Before
    public void setup() {
        wc = new WebController(wcService);
    }

    @Test
    public void getAllJobRolesReturnsListFromService() {
        var expectedList = List.of(new JobRole());
        when(wcService.getAllJobRoles()).thenReturn(expectedList);

        List<JobRole> actualList = wc.jobRoles();

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

    @Test
    public void jobSpecificationReturnsListFromService(){
        var expectedList = List.of(new JobRole());
        when(wcService.getJobSpecifications()).thenReturn(expectedList);

        List<JobRole> actualList = wc.jobSpecifications();

        verify(wcService).getJobSpecifications();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobSpecificationPassedThrough() {
        when(wcService.getJobSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wc.jobSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }

    //US003 test cases

    @Test
    public void jobCapabilityReturnsListFromService() {
        var expectedList = List.of(new JobRole());
        when(wcService.getJobCapability()).thenReturn(expectedList);

        List<JobRole> actualList = wc.jobCapability();

        verify(wcService).getJobCapability();
        assertEquals(expectedList,actualList);
    }

    @Test
    public void exceptionFromJobCapabilityPassedThrough() {
        when(wcService.getJobSpecifications()).thenThrow(new RuntimeException("Expected exception"));
        try{
            wc.jobSpecifications();
            fail("Exception was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Expected exception", e.getMessage());
        }
    }


}
