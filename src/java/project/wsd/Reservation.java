/*
 * This file is used to create a JavaBean class call Reservation, to be used in
 * other pages
 * 
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
    
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "email")
    private String email;
    @XmlAttribute(name = "bookID")
    private int bookID;
    @XmlAttribute(name = "resID")
    private int resID;
    
    public Reservation(){
        
    }

    public Reservation(String username, String email, int bookID, int resID) {
        this.username = username;
        this.email = email;
        this.bookID = bookID;
        this.resID = resID;
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

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }


}
