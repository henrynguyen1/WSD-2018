/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 *
 * @author HenryNguyen
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
public class Textbook implements Serializable {

    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "author")
    private String author;
    @XmlElement(name = "ISBN")
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
    @XmlAttribute(name = "bookID")
    private int bookID;
    @XmlElement(name = "lister")
    private String lister;
    @XmlElement(name = "condition")
    private String condition;

    public Textbook() {

    }

    public Textbook(String title, String author, String ISBN, String publisher, String date, String abstracts, String category, String reservation, int bookID, String lister, String condition) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.date = date;
        this.abstracts = abstracts;
        this.category = category;
        this.reservation = reservation;
        this.bookID = bookID;
        this.lister = lister;
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    
    public String getLister() {
        return lister;
    }

    public void setLister(String lister) {
        this.lister = lister;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    @Override
    public boolean equals(Object other) {
        return other instanceof Textbook && ((Textbook) other).title.equals(title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
