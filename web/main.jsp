<%-- 
    Document   : main
    Created on : May 16, 2018, 1:39:06 PM
    Author     : bsapr
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="project.wsd.*" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%String test = request.getParameter("title");
    String xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?unique";
    String title = request.getParameter("title") == null ? "" : URLEncoder.encode(request.getParameter("title"), "UTF-8").replace("+", "%20");
    if (test != null) {
        xml = "http://localhost:8080/WSD-2018/rest/textbook/filter?title=" + title;
    }%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <jsp:include page="./WEB-INF/Includes/Header.jsp"/>
    </head>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <body>
        <%if (user != null) {%>
                <div class="container">   
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
    
</body>
</html>
