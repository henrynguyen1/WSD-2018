/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@Path("/lister")
public class ListerService {

    @Context
    private ServletContext application;

    private ListerApplication getListerApp() throws JAXBException, IOException {
        // The web server can handle requests from different clients in parallel.
        // These are called "threads".
        //
        // We do NOT want other threads to manipulate the application object at the same
        // time that we are manipulating it, otherwise bad things could happen.
        //
        // The "synchronized" keyword is used to lock the application object while
        // we're manpulating it.
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
    
    @Path("users")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public User getUsers(@QueryParam("userID") int userID) throws JAXBException, IOException {
        return getListerApp().getUsers().getUser(userID);}
    
    

}
