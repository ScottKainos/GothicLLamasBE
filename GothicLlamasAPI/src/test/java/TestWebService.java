import com.kainos.ea.DBConnection;
import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.resources.WebService;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestWebService {

    WebService ws = new WebService();

    List<CapabilitiesAndRoles> testArray = ws.getMsg();
    CapabilitiesAndRoles testEntry = testArray.get(0);

    @Test
    public void getMsgQueryReturnsExpectedValueTest() {
        assertEquals("Software Engineer",testEntry.getJobRole());
    }

    @Test
    public void getMsgCorrectNumberOfRolesTest() {
        ResultSet controlRS = ws.getDb().customQuery("SELECT DISTINCT jobRole AS \"Job Role\" FROM capabilityAndRoles");
        List<CapabilitiesAndRoles> controlArray = new ArrayList<CapabilitiesAndRoles>();
        try {
            while (controlRS.next()) {
                CapabilitiesAndRoles obj = new CapabilitiesAndRoles();
                //collect job role into object
                obj.setJobRole(controlRS.getString("Job Role"));
                controlArray.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Error getting control set from db");
        }
        assertEquals(controlArray.size(),testArray.size());
    }


}