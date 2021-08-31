package com.kainos.ea.resources;

import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
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
}
