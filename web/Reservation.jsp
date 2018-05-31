<%-- 
    Document   : Reservation
    Created on : 25/05/2018, 11:00:09 AM
    Author     : HenryNguyen
    This page is used to reserve a chosen book
--%>

<%@page import="java.net.URLEncoder" import="project.wsd.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!-- Building URL based on filtering of bookID -->
<%String bookID = request.getParameter("bookID");%>
<% String xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?bookID=" + bookID;%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reserve a book</title>
    <!-- Importing header for webpage -->
    <jsp:include page="./WEB-INF/Includes/Header.jsp"/>
<h3 align="center">Reserve Textbook </h3>
</head>
<body>
    <div class="container">   
        <!-- Prepare form to send over to reservation action page -->
        <form action="ReserveAction.jsp" method="post">
            <c:import url="<%=xml%>" var="inputDoc" />

            <!-- Importing rules from reservation.xsl -->
            <c:import url="./WEB-INF/Reservation.xsl" var="stylesheet" />

            <!-- Transform xml inputDoc using stylesheet -->
            <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
            </x:transform>
            <%User user = (User) session.getAttribute("user");%>


            <%if (user != null) {
                    String test = "http://localhost:8080/WSD-2018/rest/reservations/filter?bookID=" + bookID;
                    if (test != "") {
            %>
            <!-- Checking reservation details for the book -->
            <h3 align="center">Here are the reservations for this book</h3>
            <br>
            <c:import url="<%=test%>" var="inputDoc2" />


            <c:import url="./WEB-INF/ReserveAction.xsl" var="stylesheet2" />

            <!-- Transform xml inputDoc using stylesheet -->
            <x:transform xml  = "${inputDoc2}" xslt = "${stylesheet2}">        
            </x:transform>
            <%} else {
            %>
            Sorry, there are no Reservations for this book.
            <%
                }
            } else {%>
            <table class="table table-bordered">
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
                </tr>
            </table>
            <%}%>
        </form>
    </div>
    <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
</body>

