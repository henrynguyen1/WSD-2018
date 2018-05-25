/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;
/**
 *
 * @author HenryNguyen
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
public class Reservation implements Serializable{
    @XmlElement(name = "reservationID")
    private String reservationID;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "bookID")
    private int bookID;
    
    public Reservation(){
        
    }
    public Reservation(String reservationID, String username, String email, String title){
        this.reservationID = reservationID;
        this.username = username;
        this.email = email;
        this.title = title;
        
       
        
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
            
}
