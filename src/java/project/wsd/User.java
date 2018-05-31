/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;

/**
 *
 * @author Anh Minh Tran
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Henry
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="User")
public class User implements Serializable {

    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "password")
    private String password;
    @XmlAttribute(name = "userID")
    private int userID;


    public User() {
    }

    public User(String email, String name, String password, int userID) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userID = userID;
       
    }
        public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}