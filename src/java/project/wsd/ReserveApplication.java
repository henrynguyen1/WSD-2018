/*
 * This will generate ReserveApplication bean which will be used in the 
 * "application" level scope
 *  This file will attemp to load list of reservation from the XML
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


    

public void setFilePath(String filePath) {
        this.filePath = filePath;
        try {
            // Create the unmarshaller
            JAXBContext jc = JAXBContext.newInstance(Reservations.class);
            Unmarshaller u = jc.createUnmarshaller();

            // unmarshal the object from the file
            FileInputStream fin = new FileInputStream(filePath);
            reservations = (Reservations) u.unmarshal(fin); 
            fin.close();
        } catch (Exception e) {
            if (reservations == null) {
                reservations = new Reservations();
            }
        }
    }
public void updateXML(Reservations reservations, String filePath) throws Exception {
        this.reservations = reservations;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Reservations.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(reservations, fout);
        fout.close();
    }


public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    
}

