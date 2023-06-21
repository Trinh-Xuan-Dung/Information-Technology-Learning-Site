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
        <%@include file="head.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AddModule.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1 class="section-title">Add week</h1>
        <div class="form-module">
            <form action="AddWeek" method="POST">
                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Week number</label>
                    <input name="weeknum" type="number"  class="form-control" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Week Title</label>
                    <input name="weektitle" type="text"  class="form-control" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form6Example7">Week Description</label>
                    <textarea id="id" name="weekdescription" class="form-control"  rows="5" cols="20"></textarea>
                </div>



                <input type="hidden" name="moduleId" value="${moduleId}"/>
                <input class="btn btn-primary"  type="submit" value="Add"/>
            </form>
        </div>



    </body>
</html>
