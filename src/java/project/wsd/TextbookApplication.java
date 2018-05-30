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
public class TextbookApplication implements Serializable {

    private String filePath;
    private Textbooks textbooks;

    public TextbookApplication(String filePath, Textbooks textbooks) {
        this.filePath = filePath;
        this.textbooks = textbooks;
    }

    public TextbookApplication() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        try {
            // Create the unmarshaller
            JAXBContext jc = JAXBContext.newInstance(Textbooks.class);
            Unmarshaller u = jc.createUnmarshaller();

            // Now unmarshal the object from the file
            FileInputStream fin = new FileInputStream(filePath);
            textbooks = (Textbooks) u.unmarshal(fin); // This loads the "shop" object
            fin.close();
        } catch (Exception e) {
            if (textbooks == null) {
                textbooks = new Textbooks();
            }
        }
    }

    public void updateXML(Textbooks textbooks, String filePath) throws Exception {
        this.textbooks = textbooks;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Textbooks.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(textbooks, fout);
        fout.close();
    }

    public void saveTextbooks() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Textbooks.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(textbooks, fout);
        fout.close();
    }
    

    public Textbooks getTextbooks() {
        return textbooks;
    }

    public void setTextbook(Textbooks textbooks) {
        this.textbooks = textbooks;
    }

}
