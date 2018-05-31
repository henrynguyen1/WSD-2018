/*
 * This file create a Javabean class Textbooks to access a list of 
 * textbooks in the website
 */
package project.wsd;

/**
 *
 * @author bsapr
 */
import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "textbooks")
public class Textbooks implements Serializable {
    
    @XmlElement(name = "textbook")
    private ArrayList<Textbook> list = new ArrayList<Textbook>();
    
    
    public ArrayList<Textbook> getList(){
    return list;
    }
    
    public void addTextbook(Textbook textbook){
    list.add(textbook);
    }
    
    public void removeTextbook(Textbook textbook){
        list.remove(textbook);
    }
    // Retrieve textbook based on bookID
    public Textbook getTextbook(int bookID){
       for (Textbook textbook: list){
           if(textbook.getBookID() == bookID)
               return textbook;
       }
       return null;
    }    
    // Retrieve the bok based on title
    public Textbook getTextbookT(String title){
        for (Textbook textbook:list){
            if(textbook.getTitle().equals(title))
                return textbook;
        }
        return null;
    }
    
}
