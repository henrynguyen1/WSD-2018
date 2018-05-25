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
<% String xml = "http://localhost:8080/WSD-2018/rest/textbook/textbookTitle?title="+ title; %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details <%= title %> </title>
    <h1>Book Details <%=title%></h1>
    </head>
    <body>
           <!-- Replace the URL value with the location of Textbook.xml on your PC-->
           <c:import url="<%=xml%>" var="inputDoc" />

    <!-- Replace the URL value with the location of main.xsl on your PC-->
    <c:import url=".//BookDetail.xsl"
              var="stylesheet" />
     
    <!-- Transform xml inputDoc using stylesheet -->
    <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
      <x:param name="bgColor"  value="lightgreen" />
    </x:transform>
    
    <form action = "Reservation.jsp">        
             <tr>
                <td>Reserve Book</td>
                <td><input type="submit" value="reserve"> </td>
            </tr>

    </form>
</body>
</html>
