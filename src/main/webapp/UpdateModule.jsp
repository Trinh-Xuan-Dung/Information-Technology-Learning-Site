<%-- 
    Document   : UpdateModule
    Created on : Jun 13, 2023, 6:51:57 PM
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
       <h1>Edit Module</h1>

        <form action="UpdateModule" method="post">
            <input type="hidden" name="moduleId" value="${oldmodule.moduleId}"/>
            <input type="hidden" name="courseID" value="${oldmodule.courseId}"/>
            <table border="1" style="border-collapse: collapse" >

                <tbody>
                    <tr>
                        <td>Module Name:</td>
                        <td><input type="type" name="moduleName" value="${oldmodule.moduleName}"></td>
                    </tr>

                    <tr>
                        <td>Module Description</td>
                        <td><textarea id="id" name="modulecourdescription" rows="5" cols="20">${oldmodule.moduleDescription}</textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>

                </tbody>
            </table>
        </form>
    </body>
</html>
