/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd;
import java.io.*;
import javax.xml.bind.*;

/**
 *
 * @author Henry
 */
public class TextbookApplication {
     private String filePath;
     private Textbook textbooks;
     
     public TextbookApplication(String filepath, Textbook textbooks){
    this.filePath = filePath;
    this.textbooks = textbooks;
}
     
     public TextbookApplication(){
}
     
     public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws Exception {
        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller u = jc.createUnmarshaller();
 
        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        textbooks = (Textbook)u.unmarshal(fin); // This loads the "shop" object
        fin.close();
    }


    
    public void updateXML(Users users, String filePath) throws Exception {
        this.textbooks = textbooks;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users, fout);
        fout.close();
    }
    
    
    public void saveTextbook() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(textbooks, fout);
        fout.close();
    }
    
    public Textbook getTextbook() {
        return textbooks;
    }

    public void setTextbook(Textbook textbooks) {
        this.textbooks = textbooks;
    }
    

}

