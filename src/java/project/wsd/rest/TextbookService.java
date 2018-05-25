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
import java.util.ArrayList;
import java.util.List;

@Path("/textbook")
public class TextbookService {

    @Context
    private ServletContext application;

    private TextbookApplication getTextbookApp() throws JAXBException, IOException {

        synchronized (application) {
            TextbookApplication textbookApp = (TextbookApplication) application.getAttribute("textbookApp");
            if (textbookApp == null) {
                textbookApp = new TextbookApplication();
                textbookApp.setFilePath(application.getRealPath("WEB-INF/textbook.xml"));
                application.setAttribute("textbookApp", textbookApp);
            }
            return textbookApp;
        }

    }

    @Path("textbookID")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Textbook getTextbooks(@QueryParam("bookID") int bookID) throws JAXBException, IOException {
        return getTextbookApp().getTextbooks().getTextbook(bookID);
    }

    @Path("textbooks")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Textbooks getTextbook() throws JAXBException, IOException {
        return getTextbookApp().getTextbooks();
    }
       
    @Path("textbookTitle")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Textbook> getTextbook(@QueryParam("title") String title) throws JAXBException, IOException {
        //return getTextbookApp().getTextbooks().getTextbookT(title);
        List<Textbook> books = new ArrayList<Textbook>();
        
        Textbook book = getTextbookApp().getTextbooks().getTextbookT(title);
        if (book != null) {
            books.add(book);
        }
        
        return books;
    }

}