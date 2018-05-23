/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Anh Minh Tran
 */
@Path("/textbook") 
public class TextbookService {
    
    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }
    
}
