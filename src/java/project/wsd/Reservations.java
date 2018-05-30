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
@XmlRootElement(name = "reservations")
public class Reservations implements Serializable{
@XmlElement(name = "reservation")
    private ArrayList<Reservation> list = new ArrayList<Reservation>();
    
    
    public ArrayList<Reservation> getList(){
    return list;
    }
    
    public void addReservation(Reservation reservation){
    list.add(reservation);
    }
    
    public void removeReservation(Reservation reservation){
        list.remove(reservation);
    }
    
    public Reservation getReservation(int bookID){
       for (Reservation reservation: list){
           if(reservation.getBookID() == bookID)
               return reservation;
       }
       return null;
    }    
    
    public Reservation getReservations(String username){
        for (Reservation reservation:list){
            if (reservation.getUsername().equals(username))
                return reservation;
        }
        return null;
    }
    
}
