/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public Textbook getTextbook(int bookID){
       for (Textbook textbook: list){
           if(textbook.getBookID() == bookID)
               return textbook;
       }
       return null;
    }    
    
    public Textbook getTextbookT(String title){
        for (Textbook textbook:list){
            if(textbook.getTitle().equals(title))
                return textbook;
        }
        return null;
    }
    
}
