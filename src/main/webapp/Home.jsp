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

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listCourse.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <%@include file="header.jsp" %>


        <div class="container mt-4">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach var="course" items="${listCToView}">
                    <div class="col">
                        <div class="card shadow-sm">
                            <!--                            <svg class="bd-placeholder-img card-img-top"   width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>-->
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                            <title>${course.courseName}</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <image xlink:href="${course.imageUrlString}" width="100%" height="100%" preserveAspectRatio="xMidYMid slice"></image>
                            <!--                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>-->
                            </svg>

                            <div class="card-body">
                                <h5 class="card-text">${course.courseName} </h5>
                                <p class="card-text">${course.courseTitle} </p>

                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a type="button" class="btn btn-sm btn-outline-secondary" href="CourseDetail?id=${course.courseId}" >View</a>
                                        <a type="button" class="btn btn-sm btn-outline-secondary" href="UpdateCourse?id=${course.courseId}">Edit</a>
                                    </div>
                                    <small class="text-muted"  >

                                        <c:forEach var="subjects" items="${course.subjects}" >

                                            <c:choose>
                                                <c:when test="${subjects.subject.subjectName == 'Java'}">
                                                    <span style="color: blueviolet;">${subjects.subject.subjectName}</span> &nbsp;
                                                </c:when>
                                                <c:when test="${subjects.subject.subjectName == 'Python'}">
                                                    <span style="color: orange;">${subjects.subject.subjectName}</span> &nbsp;
                                                </c:when>
                                                <c:when test="${subjects.subject.subjectName == 'C#'}">
                                                    <span style="color: green;">${subjects.subject.subjectName}</span> &nbsp;
                                                </c:when>
                                                <c:otherwise>
                                                    <span>${subjects.subject.subjectName}</span> &nbsp;
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <div class="text-center mt-4">
                <a class="btn btn-primary" href="listCourse?index=1">Xem thêm</a>
            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
        <br>
        <div class="grid-container">


        </div>
        <!--        <a type="button" class="btn btn-sm btn-outline-secondary" href="AddCourse">Add New Course</a>-->
        <%@include file="footer.jsp" %>
    </body>
</html>
