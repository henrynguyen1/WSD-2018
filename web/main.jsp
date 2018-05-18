<%-- 
    Document   : main
    Created on : May 16, 2018, 1:39:06 PM
    Author     : bsapr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
    </head>
    <body>        
        <!-- Replace the URL value with the location of Textbook.xml on your PC-->
    <c:import url="./Textbook.xml"
              var="inputDoc" />

    <!-- Replace the URL value with the location of main.xsl on your PC-->
    <c:import url="./main.xsl"
              var="stylesheet" />
     
    <!-- Transform xml inputDoc using stylesheet -->
    <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}">        
      <x:param name="bgColor"  value="lightgreen" />
    </x:transform>

        
    </body>
</html>
