/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import java.io.*;
import project.wsd.*;

@Path("/userbase")
public class UserService {

    @Context
    private ServletContext application;

    private UserbaseApplication getDiaryApp() throws JAXBException, IOException {
        // The web server can handle requests from different clients in parallel.
        // These are called "threads".
        //
        // We do NOT want other threads to manipulate the application object at the same
        // time that we are manipulating it, otherwise bad things could happen.
        //
        // The "synchronized" keyword is used to lock the application object while
        // we're manpulating it.
        synchronized (application) {
            UserbaseApplication Userbase = (UserbaseApplication) application.getAttribute("userBase");
            if (Userbase == null) {
                Userbase = new UserbaseApplication();
                Userbase.setFilePath(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("userBase", Userbase);
            }
            return Userbase;
        }
    }
    
    @Path("users")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Users getUsers() throws JAXBException, IOException {
        return getDiaryApp().getUsers();
    }
    
    @Path("users/{email}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("email") String email) throws JAXBException, IOException
    {
        return getDiaryApp().getUsers().getUser(email);
    }

    /**
     * YOUR METHODS WILL BE INSERTED HERE *
     */
}
