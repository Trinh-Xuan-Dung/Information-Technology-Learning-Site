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
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #9A616D;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="d-flex">
                    <div class="input-group">
                        <input class="form-control border-end-0 border rounded-pill" type="search" value="search" id="example-search-input">
                        <span class="input-group-append">
                            <button class="btn btn-outline-secondary bg-white border-bottom-0 border rounded-pill ms-n5" type="button">
                                <i class="fa fa-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mb-2 mb-lg-0 ms-auto">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item ms-end">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container">
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
                                        <button type="button" class="btn btn-sm btn-outline-secondary" href="CourseDetail?id=${course.courseId}" >View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary" href="CourseDelete?id=${course.courseId}">Edit</button>
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
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
        <br>
        <div class="grid-container">


        </div>
    </body>
</html>
