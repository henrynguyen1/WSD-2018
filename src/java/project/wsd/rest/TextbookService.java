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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    
    @Path("filter")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Textbook> getTest(@QueryParam("title") String title, @QueryParam("bookID") int bookID, @QueryParam("unique") String unique) throws JAXBException, IOException{
        List<Textbook> values = getTextbookApp().getTextbooks().getList();
        if(title !=null){
        values = values.stream().filter(new Predicate<Textbook>() {
            @Override
            public boolean test(Textbook p) {
                return p.getTitle().equals(title);
            }
        }).collect(Collectors.toList());
        
        }
         if (bookID != 0) {
            values = values.stream().filter(new Predicate<Textbook>() {
                @Override
                public boolean test(Textbook p) {
                    return p.getBookID() == bookID;
                }
            }).collect(Collectors.toList());
        }
          if (unique != null) {
            Set<Textbook> uniqueValues = new HashSet<>();
            uniqueValues.addAll(values);
            values = new ArrayList<>(uniqueValues);
        }
        return values;
    }

}
