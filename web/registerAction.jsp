<%-- 
    Document   : registerAction
    Created on : 30/05/2018, 7:51:34 PM
    Author     : Anh Minh Tran

    This page will handle register data from register jsp file
--%>


<html>
    <%@page import="project.wsd.*" contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Textbook Confirm</title>
            <%-- Import header for web page --%>
            <jsp:include page="WEB-INF/Includes/Header.jsp"/>
        </head>
        <body>
            <%-- Setting access to User xml --%>
            <% String filePath = application.getRealPath("WEB-INF/User.xml");%>
            <jsp:useBean id="listerApp" class="project.wsd.ListerApplication" scope="application">
                <jsp:setProperty name="listerApp" property="filePath" value="<%=filePath%>"/>
            </jsp:useBean>
            <%-- Take data and create a new xml field for user --%>
            <%
                Users users = listerApp.getUsers();

                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                int fetchID = users.getList().size();
                int userID = fetchID++;

                User user = new User(email, name, password, userID);
                users.addUser(user);
                listerApp.updateXML(users, filePath);
            %>
            <div class="container"><h2>You have successfully registered.</h2></div>
        </body>
    </html>
