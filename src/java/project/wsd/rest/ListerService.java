
package project.wsd.rest;

/**
 *
 * @author bsapr
 */
import project.wsd.*;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import java.io.*;

// The service will be available through the link "/lister"
@Path("/lister")
public class ListerService {

    @Context
    private ServletContext application;

    private ListerApplication getListerApp() throws JAXBException, IOException {
        synchronized (application) {
            ListerApplication listerApp = (ListerApplication) application.getAttribute("listerApp");
            if (listerApp == null) {
                listerApp = new ListerApplication();
                listerApp.setFilePath(application.getRealPath("WEB-INF/user.xml"));
                application.setAttribute("listerApp", listerApp);
            }
            return listerApp;
        }
    }
    
    // The service will be available through the link "users
    // The result would be produced in XML form
    @Path("users")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public User getUsers(@QueryParam("userID") int userID) throws JAXBException, IOException {
        return getListerApp().getUsers().getUser(userID);}
    
    

}
