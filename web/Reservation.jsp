<%-- 
    Document   : Reservation
    Created on : 25/05/2018, 11:00:09 AM
    Author     : HenryNguyen
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%String bookID = request.getParameter("bookID");%>
<% String xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?bookID=" + bookID;%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1>Reserve Textbook </h1>
    </head>
    <body>
        <c:import url="<%=xml%>" var="inputDoc" />


    <c:import url="./Reservation.xsl" var="stylesheet" />

    <!-- Transform xml inputDoc using stylesheet -->
    <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
    </x:transform>
    
    <form action="ReserveAction.jsp" method ="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type ="text" name="Username"> </td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type ="text" name="Email"> </td>
            </tr>
             <tr>
                 <td>Submit Reservation</td>
                 <td><input type = "submit" name  = "Register"> </td>
                 </form>
    </body>
</html>
