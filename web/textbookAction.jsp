<%-- 
    Document   : textbookAction
    Created on : May 28, 2018, 11:25:48 PM
    Author     : bsapr

    This page takess input from addTextbook and put them into XML file
--%>

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
        <%-- Setting access for Textbook xml --%>
                    <% String filePath = application.getRealPath("WEB-INF/Textbook.xml");%>
        <jsp:useBean id="textbookApp" class="project.wsd.TextbookApplication" scope="application">
            <jsp:setProperty name="textbookApp" property="filePath" value="<%=filePath%>"/>
            <%-- Take input from previous form and create a new xml space for book --%>
        </jsp:useBean>
                    <%
                        User user = (User)session.getAttribute("user");
                        Textbooks textbooks = textbookApp.getTextbooks();
                        String title = request.getParameter("title");
                    String author = request.getParameter("author");
                    String ISBN = request.getParameter("ISBN");
                    String publisher = request.getParameter("publisher");
                    String date = request.getParameter("date");
                    String abstracts = request.getParameter("abstracts");
                    String category = request.getParameter("category");
                    String lister = user.getName();
                    String condition = request.getParameter("condition");
                    String reservation = "no";
                    int fetchID = textbooks.getList().size();
                    int bookID = fetchID+1;
                    
                    %>
                    <%
                        Textbook textbook = new Textbook(title, author, ISBN, publisher, date, abstracts, category, reservation, bookID, lister, condition);
                        session.setAttribute("textbook", textbook);
                        textbooks.addTextbook(textbook);
                        textbookApp.updateXML(textbooks, filePath);
                        
                    %>
                    <div class="container"><h2>Your book as been successfully added.</h2></div>
    </body>
    <%-- Import footer for web page --%>
    <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
</html>
