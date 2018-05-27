<%-- 
    Document   : ReserveAction
    Created on : 25/05/2018, 3:45:56 PM
    Author     : HenryNguyen
--%>

<%@page language="java" import="project.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserve Action</title>
    </head>
    <body>
        <% String filePath = application.getRealPath("WEB-INF/Reservation.xml"); %>
        
        <jsp:useBean id="reserveApp" class="project.wsd.ReserveApplication" scope="application">
            <jsp:setProperty name="reserveApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>
         <jsp:useBean id="flightApp" class="project.wsd.ReserveApplication"> 
        
             <%
               String username = request.getParameter("Username");
               String email = request.getParameter("Email");
               int bookID = Integer.parseInt(request.getParameter("bookID"));
               User user = (User) session.getAttribute("user");
                 
                  if ((user != null) && ("true".equalsIgnoreCase("bookID"))) %>
             <p>Book Successfully Reserved </p>    
             <%  
               project.wsd.Reservation = new project.wsd.Reservation();
              
                 
             
             %>
             
    </body>
</html>
