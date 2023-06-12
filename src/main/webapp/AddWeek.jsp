<%-- 
    Document   : AddWeek
    Created on : Jun 5, 2023, 11:23:49 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add week</h1>
        <form action="AddWeek" method="POST">
             <input type="hidden" name="moduleId" value="${moduleId}"/>
             <table border="1" style="border-collapse: collapse"  >

                <tbody>
                    <tr>
                        <td>Week number:</td>
                        <td><input  type="number" name="weeknum"></td>
                    </tr>

                    <tr>
                        <td>Week Title</td>
                        <td><input type="text" name="weektitle"></td>
                    </tr>
                    <tr>
                        <td>Week Description</td>
                        <td><textarea id="id" name="weekdescription" rows="5" cols="20"></textarea></td>
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
