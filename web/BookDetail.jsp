<%-- 
    Document   : BookDetail
    Created on : 23/05/2018, 3:19:17 PM
    Author     : HenryNguyen
--%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%String title = request.getParameter("title") == null ? "" : URLEncoder.encode(request.getParameter("title"), "UTF-8").replace("+", "%20"); %>
<%String headerT = request.getParameter("title");%>
<% String xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?title=" + title;%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details <%= headerT%> </title>
        <jsp:include page="WEB-INF/Includes/Header.jsp"/>
</head>
<body>
    <div class="container">
        <h3>Book Details: <%= headerT%> </h3>
        <form action = "Reservation.jsp" method="post">  
            <c:import url="<%=xml%>" var="inputDoc" />


            <c:import url=".//WEB-INF/BookDetail.xsl"
                      var="stylesheet" />

            <!-- Transform xml inputDoc using stylesheet -->
            <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
            </x:transform>

            <p><input type="submit" value="Reserve"/></p> 
        </form>
    </div>
</body>
</html>
