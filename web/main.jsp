<%-- 
    Document   : main
    Created on : May 16, 2018, 1:39:06 PM
    Author     : bsapr

    This is the main page for website, display simple info of books and set 
    options for viewers and users
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="project.wsd.*" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%String test = request.getParameter("lister");
    String xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?unique";
    String lister = request.getParameter("lister") == null ? "" : URLEncoder.encode(request.getParameter("lister"), "UTF-8").replace("+", "%20");
    if (test != null) {
        xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?lister=" + lister;
    }%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <%-- Import header jsp for web page --%>
        <jsp:include page="./WEB-INF/Includes/Header.jsp"/>
    </head>
    <%-- Check if user has logged in or not to display option --%>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <body>
        <%if (user != null) {%>
        <div class="container">
            Click <a href="main.jsp?lister=<%=user.getName()%>">here</a> to show your listed books
            <c:import url="<%=xml%>"
                      var="inputDoc" />


            <c:import url="./WEB-INF/main2.xsl"
                      var="stylesheet" />

            <!-- Transform xml inputDoc using stylesheet -->
            <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
            </x:transform>
            <div class="container"><jsp:include page="./addTextbook.jsp"/></div>
        </div>
        <%} else {%>
        <div class="container">
            <c:import url= "<%=xml%>"
                      var="inputDoc" />

            <c:import url="./WEB-INF/main.xsl"
                      var="stylesheet" />

            <!-- Transform xml inputDoc using stylesheet -->
            <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
            </x:transform>
        </div>
        <%}%>
        <%-- Import footer for web page --%>
        <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
    </body>
</html>
