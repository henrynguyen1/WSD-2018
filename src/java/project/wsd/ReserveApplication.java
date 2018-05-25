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
 * @author HenryNguyen
 */
public class ReserveApplication implements Serializable{
    private String filePath;
    private Reservations reservations;
    

public ReserveApplication(){

}
public ReserveApplication(String filePath, Reservations reservations){
    this.filePath = filePath;
    this.reservations = reservations;
}

public String getFilePath() {
        return filePath;
    }


    

public void setFilePath(String filePath) {//throws JAXBException, FileNotFoundException, IOException {
        this.filePath = filePath;
        try {
            // Create the unmarshaller
            JAXBContext jc = JAXBContext.newInstance(Reservations.class);
            Unmarshaller u = jc.createUnmarshaller();

            // Now unmarshal the object from the file
            FileInputStream fin = new FileInputStream(filePath);
            reservations = (Reservations) u.unmarshal(fin); // This loads the "shop" object
            fin.close();
        } catch (Exception e) {
            if (reservations == null) {
                reservations = new Reservations();
            }
        }
    }
public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    
}
