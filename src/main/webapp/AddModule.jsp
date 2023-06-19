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
        <%@include file="head.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AddModule.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1 class="section-title">Add Module</h1>
        <div class="form-module">
            <form action="AddModule" method="post">

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Module Name:</label>
                    <input name="moduleName" type="type" id="form5Example1" class="form-control" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Module Description</label>
                    <input name="modulecourdescription" type="type"  class="form-control" />

                </div>
                <input type="hidden" name="courseId" value="${courseid}"/>
                <input class="btn btn-primary"  type="submit" value="Add"/>
            </form>
        </div>

    </body>
</html>
