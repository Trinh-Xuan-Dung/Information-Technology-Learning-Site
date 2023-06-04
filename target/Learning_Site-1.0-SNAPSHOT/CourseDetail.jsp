<%-- 
    Document   : CourseDetail
    Created on : Jun 3, 2023, 3:50:34 PM
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
        <h1>${DetailOfcourse.courseName} Detail</h1>
        <div class="grid-item">
            <!-- Display course details here -->
            <h2>${DetailOfcourse.courseName}</h2>
            <p>${DetailOfcourse.courseDescription}</p>
            <!-- Add more fields as needed -->

            <img src="${DetailOfcourse.imageUrlString}" alt="${DetailOfcourse.courseName}" width="200" height="150">

        </div>
        <a href="AddModule?cid=${DetailOfcourse.courseId}">Add Module</a>
        <hr><!-- comment -->
        <h3>List of Module Here</h3>
       <div>
        <c:forEach var="module" items="${ListmoduleByCourse}">
            <div>
              
                <p>Module Name: ${module.moduleName}</p>
                <p>Module Description: ${module.moduleDescription}</p>
                <a href="AddWeek?mid=${module.moduleId}">Add Week</a>
            </div>
            
        </c:forEach>
    </div>
        
        

    </body>
</html>
