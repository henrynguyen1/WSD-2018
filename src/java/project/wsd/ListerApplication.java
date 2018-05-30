/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Anh Minh Tran
 */
public class ListerApplication implements Serializable {

    private String filePath;
    private Users users;

    public ListerApplication() {
    }

    public ListerApplication(String filePath, Users users) {
        this.filePath = filePath;
        this.users = users;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        try {
            // Create the unmarshaller
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller u = jc.createUnmarshaller();

            // Now unmarshal the object from the file
            FileInputStream fin = new FileInputStream(filePath);
            users = (Users) u.unmarshal(fin); // This loads the "shop" object
            fin.close();
        } catch (Exception e) {
            if (users == null) {
                users = new Users();
            }
        }
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
