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
    private static TextbookApplication bookA;

    private TextbookApplication getBookApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            TextbookApplication bookApp = (TextbookApplication) application.getAttribute("bookApp");
            if (bookApp == null) {
                bookApp = new TextbookApplication();
                bookApp.setFilePath(application.getRealPath("WEB-INF/Textbook.xml"));
                application.setAttribute("bookApp", bookApp);
                bookA = bookApp;
            }
            return bookApp;
        }
    }

    public List<Textbook> fetchBook()  {
        List<Textbook> books = new ArrayList<Textbook>();
        
        books = getBookApp().getTextbooks().getList();   
        return books;
    }
    
    public List<Textbook> fetchBookID(int ID){
        List<Textbook> books = new ArrayList<Textbook>();
        
        Textbook book = getBookApp().getTextbooks().getTextbook(ID);
        if (book != null) {
            books.add(book);
        }
        
        return books;
    }
    
    public List<Textbook> fetchBookT(String title){
        List<Textbook> books = new ArrayList<Textbook>();
        Textbook book = getBookApp().getTextbooks().getTextbookT(title);
        if (book != null)
        {
            books.add(book);
        }
        return books;
    }
    
    public void addBook(String title, String author, String ISBN, String publisher, String abstracts, String category, String reservation) throws Exception{
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        String filePath = application.getRealPath("WEB-INF/Textbook.xml") ;
        Textbook textbook = new Textbook();
        
        textbook.setAuthor(author);
        textbook.setTitle(title);
        textbook.setISBN(ISBN);
        textbook.setPublisher(publisher);
        textbook.setAbstracts(abstracts);
        textbook.setCategory(category);
        textbook.setReservation(reservation);
        Textbooks textbooks = new Textbooks(); 
        textbooks.addTextbook(textbook);
        bookA.updateXML(textbooks, filePath);
        
    }
}
