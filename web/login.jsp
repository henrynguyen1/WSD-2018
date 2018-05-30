<%--
    Document   : login
    Created on : 07/05/2018, 5:13:32 PM
    Author     : Henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="./WEB-INF/Includes/Header.jsp"/>

        <form action="loginAction.jsp" method ="post">
            <div class="container">
                <h1 align="center">Login</h1>
                <table align="center">
                    <tr>
                        <td>Email</td>
                        <td><input type ="text" name="email"> </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type ="password" name="password"> </td>
                    </tr>
                    <tr>
                        <td>Login</td>
                        <td><input type ="submit" value="login" class="btn btn-primary"></td>
                    </tr>
                    </form>
                </table>
            </div>

        </form>
    </body>
    <jsp:include page="./WEB-INF/Includes/Footer.jsp"/>
</html>