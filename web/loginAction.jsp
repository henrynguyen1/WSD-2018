<%-- 
    Document   : loginAction
    Created on : 07/05/2018, 5:35:18 PM
    Author     : Henry

    This pages receive input from login.jsp to handle the action
--%>
<%@page language="java" import="project.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Action</title>
        <%-- Import header for web page --%>
        <jsp:include page="WEB-INF/Includes/Header.jsp"/>
    </head>
    <body>
        <%-- Create variable to access UserXML --%>
        <% String filePath = application.getRealPath("WEB-INF/User.xml");%>
        <jsp:useBean id="listerApp" class="project.wsd.ListerApplication" scope="application">
            <jsp:setProperty name="listerApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>
        <%-- Checking condition to login for input data and verify the status --%>
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Users users = listerApp.getUsers();
            User user = users.login(email, password);

            if (user != null) {
                session.setAttribute("user", user);
        %>
        <div class="container">
            <p>Login successful. Click <a href="main.jsp" >here </a> 
                to proceed to the main page </p>
        </div>
        <%} else { %>
        <div class="container">
            <p>Password incorrect. Click <a href="login.jsp">here</a> 
                to try again.</p>
        </div>
        <% }%>

    </body>
    <%-- Import footer for web page --%>
    <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
</html>