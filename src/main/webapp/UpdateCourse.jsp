<%-- 
    Document   : UpdateCourse
    Created on : Jun 6, 2023, 10:14:39 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h1 class="section-title">Update Course</h1>
        <div class="form-module">
            <form action="UpdateCourse" method="post">
                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Course Name</label>
                    <input name="coursenameupdate" type="type"  class="form-control" value="${oldCourse.courseName}" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Course Image</label>
                    <input name="courseimageupdate" type="type"  class="form-control" value="${oldCourse.imageUrlString}" />

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Course Subject</label>
                    <c:forEach var="subject" items="${listSubjectToView}">
                        <label>
                            <input type="checkbox" name="selectedSubjects" value="${subject.subjectId}" 
                                   <c:forEach var="selectedSubject" items="${listScSelected}">
                                       <c:if test="${selectedSubject.subjectId == subject.subjectId}">
                                           checked
                                       </c:if>
                                   </c:forEach> />
                            ${subject.subjectName}
                        </label>
                    </c:forEach>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form5Example1">Course Description</label>
                    <textarea id="id" name="courdescriptionupdate" class="form-control"  rows="5" cols="20"></textarea>

                </div>    
                <input class="btn btn-primary"  type="submit" value="Save"/>
                <input name="courseidupdate" type="hidden" value="${courseId}"/>           
            </form>
        </div>
        <script>
            document.querySelector('#myForm').addEventListener('submit', function(event) {
                var checkboxes = document.querySelectorAll('input[name="selectedSubjects"]:checked');
    
                if (checkboxes.length === 0) {
                    event.preventDefault(); // Prevent form submission
                    alert('Please select at least one option.');
                }
            });
        </script>
    </body>
</html>
