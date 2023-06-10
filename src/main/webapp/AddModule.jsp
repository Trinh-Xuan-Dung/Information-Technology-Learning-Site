<%-- 
    Document   : AddModule
    Created on : Jun 4, 2023, 9:19:25 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Module</h1>

        <form action="AddModule" method="post">
            <input type="hidden" name="courseId" value="${courseid}"/>
            <table border="1" style="border-collapse: collapse" >

                <tbody>
                    <tr>
                        <td>Module Name:</td>
                        <td><input type="type" name="moduleName"></td>
                    </tr>

                    <tr>
                        <td>Module Description</td>
                        <td><textarea id="id" name="modulecourdescription" rows="5" cols="20"></textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Add"/></td>
                    </tr>

                </tbody>
            </table>
        </form>
    </body>
</html>
