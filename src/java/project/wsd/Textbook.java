/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HenryNguyen
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "textbook")
public class Textbook implements Serializable {
    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "author")
    private String author;
    
    @XmlAttribute(name = "info")
    private String info;
    
    @XmlAttribute(name = "ISBN")
    private String ISBN;

    @XmlElement(name = "publisher")
    private String publisher;
    
    @XmlElement(name = "date")
    private String date;
    
    @XmlElement(name = "abstracts")
    private String abstracts;
    
    @XmlElement(name = "category")
    private String category;
    
    @XmlElement(name = "reservation")
    private String reservation;
    
   


public Textbook(String title, String author, String ISBN, String publisher, String abstracts, String category, String reservation) {

this.title = title;
this.author = author;
this.ISBN = ISBN;
this.publisher = publisher;
this.abstracts = abstracts;
this.category = category;
this.reservation = reservation;
}




public Textbook(){

}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info = info;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }



}
