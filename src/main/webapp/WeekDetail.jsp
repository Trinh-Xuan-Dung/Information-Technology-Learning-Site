<%-- 
    Document   : WeekDetail
    Created on : Jun 14, 2023, 12:08:40 AM
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
        <h1>Week Detail World!</h1>
        <div class="d-flex flex-row">
            <div class="col-4">
                <div>
                    <h4>${weekToView.weekTilte}</h4>
                </div>
                <div class="col">
                    <div></div>
                    <div>Lesson 1</div>
                    <div>Quiz1</div>
                    <div>Assignment 1</div>

                </div>

            </div>
            <div class="col-6">content of week here:contain tile of all component in week</div>
        </div>

    </body>
</html>
