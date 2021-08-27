import com.kainos.ea.DBConnection;
import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.resources.WebService;
import com.kainos.ea.objects.CapabilitiesAndRoles;
import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONArray;
import java.util.*;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestWebService {

    WebService ws = new WebService();

    @BeforeEach
    List<CapabilitiesAndRoles> testArray = ws.getMsg();
    CapabilitiesAndRoles testEntry = testArray.get(0);

    @Test
    public void getMsgQueryReturnsExpectedValueTest() {
        assertEquals(testEntry.getJobRole(),"Software Engineer");
        assertEquals(testEntry.getCapability(),"Engineering");
    }

    @Test
    public void getMsgCorrectNumberOfRolesTest() {
        assertEquals(testArray.length(), )
    }


}