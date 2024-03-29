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
        <%@include file="head.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/weekDetail.css">
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
                <<<<<<< HEAD
                <div class="d-flex flex-row" style="max-width: 600px;">
                    <div class="col-4 m-2">
                        <a class="btn btn-primary stretched-link btn-spacing text-wrap" href="listLesson?wid=${weekToView.weekId}">Lesson</a>
                    </div>
                    <div class="col-4 m-2">
                        <a class="btn btn-primary stretched-link btn-spacing text-wrap" href="createLesson?wid=${weekToView.weekId}">Create a Lesson</a>
                    </div>
                    <div class="col-4 m-2">
                        <a class="btn btn-sm btn-outline-secondary stretched-link btn-spacing text-wrap" href="AddQuiz?wid=${weekToView.weekId}">View All Quiz</a>
                    </div>
                    <div class="col-4 m-2">
                        <a class="btn btn-primary stretched-link btn-spacing text-wrap" href="listAssignment?wid=${weekToView.weekId}">Assignment</a>
                    </div>
                    <div class="col-4 m-2">
                        <a class="btn btn-primary stretched-link btn-spacing text-wrap" href="formAssignment?wid=${weekToView.weekId}">Create an Assignment</a>

                        <div class="d-flex flex-row" style="max-width: 450px;">
                            <div class="col-4 m-2">
                                <a class="btn btn-primary btn-block btn-spacing text-wrap" href="listLesson?wid=${weekToView.weekId}">Lesson</a>
                            </div>
                            <div class="col-4 m-2">
                                <a class="btn btn-primary btn-block btn-spacing text-wrap" href="createLesson?wid=${weekToView.weekId}">Create a Lesson</a>
                            </div>
                            <div class="col-4 m-2">
                                <a class="btn btn-primary btn-block btn-spacing text-wrap" href="AddQuiz?wid=${weekToView.weekId}">View All Quiz</a>
                            </div>
                            <div class="col-4 m-2">
                                <a class="btn btn-primary btn-block btn-spacing text-wrap" href="listAssignment?wid=${weekToView.weekId}">Assignment</a>
                            </div>
                            <div class="col-4 m-2">
                                <a class="btn btn-primary btn-block btn-spacing text-wrap" href="formAssignment?wid=${weekToView.weekId}">Create an Assignment</a>
                            </div>
                        </div>
                    </div>

                </div> 



                </body>
                </html>