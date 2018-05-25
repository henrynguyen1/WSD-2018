/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd.soap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import project.wsd.*;

/**
 *
 * @author Anh Minh Tran
 */
@WebService(serviceName = "TextbookSOAP")
public class TextbookSOAP {

    @Resource
    private WebServiceContext context;

    private TextbookApplication getBookApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            TextbookApplication bookApp = (TextbookApplication) application.getAttribute("bookApp");
            if (bookApp == null) {
                bookApp = new TextbookApplication();
                bookApp.setFilePath(application.getRealPath("WEB-INF/Textbook.xml"));
                application.setAttribute("bookApp", bookApp);
            }
            return bookApp;
        }
    }

    public Textbooks fetchBook()  {
        return getBookApp().getTextbooks();
    }
    
    public List<Textbook> fetchBookID(int ID){
        List<Textbook> books = new ArrayList<Textbook>();
        
        Textbook book = getBookApp().getTextbooks().getTextbook(ID);
        if (book != null) {
            books.add(book);
        }
        
        return books;
    }
}
