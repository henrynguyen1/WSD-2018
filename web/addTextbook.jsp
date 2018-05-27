<%-- 
    Document   : addTextbook
    Created on : May 27, 2018, 7:00:56 PM
    Author     : bsapr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List New Textbook</h1>

        <form action="textAction.jsp" type="post">
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type ="text" name="email"> </td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input type ="text" name="author"> </td>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td><input type ="text" name="ISBN"> </td>
                </tr>
                <tr>
                    <td>publisher</td>
                    <td><input type ="text" name="publisher"> </td>
                </tr>
                <tr>
                    <td>date</td>
                    <td><input type ="text" name="date"> </td>
                </tr>
                <tr>
                    <td>abstracts</td>
                    <td><input type ="text" name="abstracts"> </td>
                </tr>
                <tr>
                    <td>category</td>
                    <td><input type ="text" name="category"> </td>
                </tr>
                <tr>
                    <td>condition</td>
                    <td> <select name="condition">
                            <option value="poor"> Poor </option>
                            <option value="fair"> Fair </option>
                            <option value="good"> Good </option>
                            <option value="new"> New </option>
                        </select> </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Submit">

                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
