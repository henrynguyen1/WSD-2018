<%-- 
    Document   : loginAction
    Created on : 07/05/2018, 5:35:18 PM
    Author     : Henry
--%>

<%@page import="project.wsd.ListerApplication"%>
<%@page import="project.wsd.User"%>
<%@page import="project.wsd.Users"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="listApp" class="project.wsd.ListerApplication" scope="application">
    <jsp:setProperty name="ListerApplication" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
        <%
        String email = request.getParameter("email");
        String password = request.getParameter("password");
    
    Users users = listApp.getUsers();
    User user = users.login(email, password);
        
         if (user != null)
        {
            session.setAttribute("user",user);
        
            %>
            <p>Login successful. Click <a href="main.jsp" >here </a> 
           to proceed to the main page </p>
        <%}
        else
        { %>
        <p>Password incorrect. Click <a href="login.jsp">here</a> 
            to try again.</p>
        <% }%>
        
    </body>
</html>