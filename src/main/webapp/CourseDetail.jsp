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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>


        <div class=" row d-flex flex-row bd-highlight mb-3">
            <div class="col-8 p-2  d-flex flex-column justify-content-center align-items-center">
                <h1>${DetailOfcourse.courseName} Detail</h1>
                <div class="grid-item">
                    <!-- Display course details here -->
                    <h2>${DetailOfcourse.courseName}</h2>
                    <p>${DetailOfcourse.courseDescription}</p>
                    <!-- Add more fields as needed -->

                    <img src="${DetailOfcourse.imageUrlString}" alt="${DetailOfcourse.courseName}" width="200" height="150">
                    <div>
                        <small class="text-muted"  >

                        <c:forEach var="subjects" items="${DetailOfcourse.subjects}" >

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
                <a href="#">Enroll</a>
                <a href="AddModule?cid=${DetailOfcourse.courseId}">Add Module</a>

                <hr><!-- comment -->
                <h3>List of Module Here</h3>

                <div>
                    <c:forEach var="module" items="${ListmoduleByCourse}">
                        <div>

                            <p>Module Name: ${module.moduleName}</p>
                            <p>Module Description: ${module.moduleDescription}</p>
                            <a href="ModuleDetail?mid=${module.moduleId}">Module Detail</a>


                        </div>

                    </c:forEach>
                </div>
            </div>
            <div style="margin-top: 10%" class="col-4  d-flex flex-column justify-content-evenly p-2 bd-highlight">
                <div class="p-2 bd-highlight">Shareable Certificate</div>
                <div class="p-2 bd-highlight">100% online courses</div>
                <div class="p-2 bd-highlight">Flexible Schedule</div>
                <div class="p-2 bd-highlight">Beginner Level</div>
                <div class="p-2 bd-highlight">
                    <div>English</div>
                    <p style="color: grey">Subtitles: English, Chinese (Traditional), Arabic, French, Ukrainian, Portuguese (European), Italian, Portuguese (Brazilian), Vietnamese, German, Russian, Spanish, Hungarian, Chinese (Simplified), Turkish</p>

                </div>




            </div>

        </div>

    </body>
</html>
