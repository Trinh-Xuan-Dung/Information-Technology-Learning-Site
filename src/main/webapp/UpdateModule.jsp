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

        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h1 class="my-4">Cập nhật module</h1>
            <form action="UpdateModule" method="post">
                <input type="hidden" name="moduleId" value="${oldmodule.moduleId}">
                <input type="hidden" name="courseID" value="${oldmodule.courseId}">
                <div class="form-group">
                    <label for="moduleName">Module Name:</label>
                    <input type="text" class="form-control" id="moduleName" name="moduleName" value="${oldmodule.moduleName}">
                </div>
                <div class="form-group">
                    <label for="moduleDescription">Module Description:</label>
                    <textarea class="form-control" id="moduleDescription" name="moduleDescription" rows="5">${oldmodule.moduleDescription}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Save">
            </form>
        </div>

    </body>
</html>
