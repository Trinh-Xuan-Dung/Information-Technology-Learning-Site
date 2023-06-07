<%-- 
    Document   : Home
    Created on : May 31, 2023, 2:59:00 AM
    Author     : HP
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link rel="stylesheet" href="/css/listCourse.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <h1>Home Page</h1>
        <br>
        <div class="grid-container">
            <c:forEach var="course" items="${listCToView}">
                <div class="grid-item">
                    <!-- Display course details here -->
                    <h2>${course.courseName}</h2>
                    <p>${course.courseDescription}</p>
                    <!-- Add more fields as needed -->
                    <img src="${course.imageUrlString}" alt="${course.courseName}" width="200" height="150">

                    <a href="CourseDetail?id=${course.courseId}">Detail</a>
                    <a href="UpdateCourse?id=${course.courseId}">Update</a>
                    <a href="CourseDelete?id=${course.courseId}">Delete</a>
                </div>
            </c:forEach>

        </div>
    </body>
</html>
