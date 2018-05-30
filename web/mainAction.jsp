<%-- 
    Document   : mainAction
    Created on : May 27, 2018, 4:27:11 PM
    Author     : bsapr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="project.wsd.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>


        <%int bookID = Integer.parseInt(request.getParameter("delete"));%>
        <% String filePath = application.getRealPath("WEB-INF/Textbook.xml");%>
        <jsp:useBean id="textbookApp" class="project.wsd.TextbookApplication" scope="application">
            <jsp:setProperty name="textbookApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>
        <%Textbooks textbooks = textbookApp.getTextbooks(); %>

        <%if (bookID != 0) {%>
        <h1>Delete</h1>
        <%
            Textbook textbook = textbooks.getTextbook(bookID);
            session.setAttribute("textbook", textbook);
            textbooks.removeTextbook(textbook);
            textbookApp.updateXML(textbooks, filePath);

        %>
        <%}%>

    </body>
</html>
