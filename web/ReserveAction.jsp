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
        <jsp:include page="WEB-INF/Includes/Header.jsp"/>
        <title>Reserve Action</title>
    </head>
    <body>
        <% String filePath = application.getRealPath("WEB-INF/Reservation.xml");%>

        <jsp:useBean id="reserveApp" class="project.wsd.ReserveApplication" scope="application">
            <jsp:setProperty name="reserveApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>

        <%
            Reservations reservations = reserveApp.getReservations();
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            int resNew = reserveApp.getReservations().getList().size();
            int resID = resNew++;
            String username = request.getParameter("username");
            String email = request.getParameter("email");
        %>
        <%
            Reservation reservation = new Reservation(username, email, bookID, resID);
            session.setAttribute("reservation", reservation);
            reservations.addReservation(reservation);
            reserveApp.updateXML(reservations, filePath);
        %>
        
        <div class="container"><p>Book Successfully Reserved </p>    </div>


    </body>
    <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
</html>
