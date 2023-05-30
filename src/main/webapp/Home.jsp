<%-- 
    Document   : Home.jsp
    Created on : May 30, 2023, 6:30:42 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <title>Home Page</title>
    </head>
    <body> 
       
     <div class="grid-container">
        <c:forEach var="course" items="${listCToView}">
            <div class="grid-item">
                <!-- Display course details here -->
                <h2>${course.courseName}</h2>
                <p>${course.courseDescription}</p>
                <!-- Add more fields as needed -->

                <!-- Example: Display course image -->
                <img src="${course.imageUrl}" alt="${course.courseName}" width="200" height="150">
            </div>
        </c:forEach>
    </div>
        
        

    </body>
</html>
