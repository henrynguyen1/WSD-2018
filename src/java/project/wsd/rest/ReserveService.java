/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd.rest;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import project.wsd.*;



/**
 *
 * @author HenryNguyen
 */
@Path("/reservations")
public class ReserveService {
    
    @Context
    private ServletContext application;
    
    private ReserveApplication getReserveApp () throws JAXBException, IOException {
    
        
        synchronized (application) {
            ReserveApplication reserveApp = (ReserveApplication) application.getAttribute("reserveApp");
            if (reserveApp == null){
                reserveApp = new ReserveApplication();
                reserveApp.setFilePath(application.getRealPath("WEB-INF/Reservation.xml"));
                application.setAttribute("reserveApp", reserveApp);
            }
            return reserveApp;
        }
    }
    
@Path("reservation")
@GET
@Produces(MediaType.APPLICATION_XML)
public Reservations getReservations() throws JAXBException, IOException{
return getReserveApp().getReservations();
}

@Path("reservationID")
@GET
@Produces(MediaType.APPLICATION_XML)
public Reservation getReservation(@QueryParam("reservationID") String reservationID) throws JAXBException, IOException {
    return getReserveApp().getReservations().getReservation(reservationID);
}
}




