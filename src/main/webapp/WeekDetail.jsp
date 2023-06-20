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
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@include file="head.jsp" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h1 class="my-4">Details of the week in the course</h1>
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title">${weekToView.weekTilte}</h5>
                </div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">Title: Course introduction and goals</h6>
                    <p class="card-text">Description: This week will introduce the course content and the goals we want to achieve.</p>
                    <p class="card-text">Document: <a href="#">Document week 1</a></p>
                </div>
                <div class="d-flex flex-row">
                    <div class="col-4">
                        <div class="col d-flex flex-row ">
                            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Lesson</a>
                            <a type="button" class="btn btn-sm btn-outline-secondary" href="AddQuiz?wid=${weekToView.weekId}">View All Quiz</a>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Assignment</button>
                        </div>
                    </div>
                </div>
            </div>

        </div> 



    </body>
</html>
