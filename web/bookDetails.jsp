<%-- 
    Document   : bookDetails
    Created on : 22/05/2018, 2:39:15 PM
    Author     : HenryNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    project.wsd.User user  = new project.wsd.User(); 
    session.setAttribute("user", user);
    
    String reserve = request.getParameter("reserve");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details</title>
    </head>
    <body>
        
        
    <c:import url="./Textbook.xml"
              var="inputDoc" />
    <c:import url="./Textbook.xsl"
              var="stylesheet" />
    
    <% if ("true".equalsIgnoreCase(reserve)) 
    
   
    
    
    %>
    
        
       
        
        
        
        
    </body>
</html>
