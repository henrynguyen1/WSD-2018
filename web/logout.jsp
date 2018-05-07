<%-- 
    Document   : logout
    Created on : 07/05/2018, 5:32:06 PM
    Author     : Henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% session.invalidate(); %>
    <body>
        <p>You have been logged out. Click <a href="index.jsp">here </a> 
            to return to the main page</p>
    </body>
</html>
