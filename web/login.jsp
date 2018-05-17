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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="loginAction.jsp" method ="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input type ="text" name="Username"> </td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type ="password" name="password"> </td>
            </tr>
             <tr>
                <td>Login</td>
                <td><input type ="submit" name="login"> </td>
            </tr>
            </form>
</table>
            <form action ="register.jsp" method= "post">
                <table>
            <tr>
                <td>Register</td>
                <td><input type="submit" value="register"> </td>
            </tr>
        </table>
        </form>
    </body>
</html>