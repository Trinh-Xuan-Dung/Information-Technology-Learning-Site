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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CourseDetail.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <%@include file="header.jsp" %>

        <div class=" row d-flex flex-row bd-highlight mb-3 course-content">
            <div class="d-flex flex-column bd-highlight mb-3 header-course">
                <div class="background-course">
                    <div class="header-component">
                        <div class=""><h1>${DetailOfcourse.courseName}</h1></div>
                        <div class=""><img src="${DetailOfcourse.imageUrlString}" alt="${DetailOfcourse.courseName}" width="200" height="70"></div>
                    </div>
                </div>

                <div class="button-enroll">
                    <a href="#">
                        <button class="style-button">Enroll</button>
                    </a>
                    <a href="AddModule?cid=${DetailOfcourse.courseId}">
                        <button class="style-button">Add Module</button>
                    </a>
                </div>



                <div class="course-description">
                    <!-- Display course details here -->
                    <div class="about-spec"><span>About this Specialization</span></div>

                    <div class="description">
                        <p>${DetailOfcourse.courseDescription}</p>
                    </div>
                    <div class="ProductGlance">
                        <div class="p-2 bd-highlight">Shareable Certificate</div>
                        <div class="p-2 bd-highlight">100% online courses</div>
                        <div class="p-2 bd-highlight">Flexible Schedule</div>
                        <div class="p-2 bd-highlight">Beginner Level</div>
                        <div class="p-2 bd-highlight">
                            <div>English</div>
                            <p style="color: grey">Subtitles: English, Chinese (Traditional), Arabic, French, Ukrainian, Portuguese (European), Italian, Portuguese (Brazilian), Vietnamese, German, Russian, Spanish, Hungarian, Chinese (Simplified), Turkish</p>

                        </div>
                    </div>
                    <!-- Add more fields as needed -->
                </div>

                <hr><!-- comment -->
                <h3 class="section-title">Courses in this Specialization</h3>

                <div>
                    <c:forEach var="module" items="${ListmoduleByCourse}" varStatus="loop">
                        <div class="div-module">
                            <div class="index-module">
                                <p class="name-module">${loop.index + 1} </p>
                            </div>
                            <div class="content-module">
                                <p class="name-module"><a href="ModuleDetail?mid=${module.moduleId}">${module.moduleName}</a> </p>
                                <p>Description: ${module.moduleDescription}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
