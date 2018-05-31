<%-- 
    Document   : register
    Created on : 17/05/2018, 1:37:30 PM
    Author     : Anh Minh Tran

    Create form for new user to register
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registeration</title>

    </head>
    <body>
        <h1>Register</h1>
        <br>
        <br>
        <%-- Prepare form to send over to registerAction jsp --%>
        <form action="registerAction.jsp" method ="post">
        <table>
            <tr>
                <td>Email</td>
                <td><input type ="text" name="email"> </td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type ="text" name="name"> </td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type ="password" name="password"> </td>
            </tr>
            <tr>
                <td>
                <input type="submit" value="register">
                  
                </td>
            </tr>
        </table>
            </form>
    </body>
</html>
        