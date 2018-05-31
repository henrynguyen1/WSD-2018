/*
 *  This will generate ListerApplication bean which will be used in the 
 * "application" level scope
 *  This file will attemp to load list of lister from the XML
 */
package project.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

    public void updateXML(Users users, String filePath) throws Exception {
        this.users = users;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users, fout);
        fout.close();
    }
}
