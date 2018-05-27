<%-- 
    Document   : ReserveAction
    Created on : 25/05/2018, 3:45:56 PM
    Author     : HenryNguyen
--%>

<%@page language="java" import="project.wsd.*" import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserve Action</title>
    </head>
    <%
        //String username = request.getParameter("Username");
        //String email = request.getParameter("Email");
        //int bookID = Integer.parseInt(request.getParameter("bookID"));

    %>
    <body>
        <% String filePath = application.getRealPath("WEB-INF/Reservation.xml");%>

        <jsp:useBean id="reserveApp" class="project.wsd.ReserveApplication" scope="application">
            <jsp:setProperty name="reserveApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>

        <%
                    int resID = reserveApp.getReservations().getList().size();
                    int resNew = resID++;
            //Reservation reservation = new Reservation(resID, bookID, username, email);
            //reservations.addReservation(reservation);
            //reserveApp.updateXML(reservations, out);
            
        %>
        <%=resID%>
        <%=resNew%>
        <p>Book Successfully Reserved </p>    
        <%
            //project.wsd.Reservation = new project.wsd.Reservation();


        %>

    </body>
</html>
