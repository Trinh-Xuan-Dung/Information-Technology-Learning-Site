<%-- 
    Document   : Home
    Created on : May 31, 2023, 2:59:00 AM
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
                <a href="CourseUpdate?id=${course.courseId}">Update</a>
                <a href="CourseDelete?id=${course.courseId}">Delete</a>
            </div>
        </c:forEach>
          
    </div>
    </body>
</html>
