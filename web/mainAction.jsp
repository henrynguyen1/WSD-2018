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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%int bookID = 6;%>
            <% String filePath = application.getRealPath("WEB-INF/Textbook.xml");%>
        <jsp:useBean id="textbookApp" class="project.wsd.TextbookApplication" scope="application">
            <jsp:setProperty name="textbookApp" property="filePath" value="<%=filePath%>"/>
        </jsp:useBean>
        <%Textbooks textbooks = textbookApp.getTextbooks(); %>
        
            <%
                Textbook textbook = textbooks.getTextbook(bookID);
                session.setAttribute("textbook",textbook);
                textbooks.removeTextbook(textbook);
                textbookApp.updateXML(textbooks, filePath);

                %>
        
    </body>
</html>
