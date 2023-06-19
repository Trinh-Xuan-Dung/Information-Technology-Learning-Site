<%-- 
    Document   : WeekUpdate
    Created on : Jun 19, 2023, 1:22:41 AM
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
        <div class="form-module">
            <form action="UpdateWeek" method="POST">
                <input name="wid" type="hidden" value="${weekToUpdate.weekId}" >
                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Week number</label>
                    <input name="weeknum" type="number" value="${weekToUpdate.weekNumber}"  class="form-control" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Week Title</label>
                    <input name="weektitle" type="text" value="${weekToUpdate.weekTilte}"  class="form-control" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form6Example7">Week Description</label>
                    <textarea id="id" name="weekdescription"  class="form-control"  rows="5" cols="20">${weekToUpdate.weekDes}</textarea>
                </div>



                <input type="hidden" name="moduleId" value="${moduleId}"/>
                <input class="btn btn-primary"  type="submit" value="Save"/>
            </form>
        </div>
    </body>
</html>
