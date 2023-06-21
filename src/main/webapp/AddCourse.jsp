<%-- 
    Document   : AddCourse
    Created on : May 31, 2023, 3:14:10 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course Page</title>

        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <h1>Add Course</h1>
        <form action="AddCourse" method="post">
            <div class="form-outline mb-4">
                <label class="form-label" for="form5Example1">Course Name</label>
                <input type="text" class="form-control" name="coursename" />

            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form5Example1">Course Image</label>
                <input type="text" class="form-control" name="courseimage" />

            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form5Example1">Course Subject</label>
                <c:forEach var="subject" items="${listSubjectToView}">
                    <label>
                        <input type="checkbox" name="selectedSubjects" value="${subject.subjectId}" />
                        ${subject.subjectName}
                    </label>
                </c:forEach>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form6Example7">Course Description</label>
                <textarea name="courdescription " class="form-control" id="form6Example7" rows="4"></textarea>
                
            </div>


            <!-- Checkbox -->


            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-block mb-4">Add</button>
        </form>
    </body>
</html>
