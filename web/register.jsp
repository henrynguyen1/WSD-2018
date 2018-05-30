<%-- 
    Document   : register
    Created on : 17/05/2018, 1:37:30 PM
    Author     : Henry
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
                <td>Date of Birth</td>
                <td><input type = "date" name="date"> </td>
            </tr>
           
            <tr>
                <td>Agree to TOS</td>
                <td><input type="checkbox" name="tos" value="true"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                <input type="submit" value="register">
                  
                </td>
            </tr>
        </table>
</form>
        <form action="login.jsp">
                <input type="submit" value="Cancel" />
            </form>
    </body>
</html>
        