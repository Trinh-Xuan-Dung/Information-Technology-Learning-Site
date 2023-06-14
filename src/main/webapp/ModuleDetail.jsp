<%-- 
    Document   : ModuleDetail
    Created on : Jun 5, 2023, 11:59:59 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ModuleDetail.css">
        <%@include file="head.jsp" %>
    </head>
    <body>

        <%@include file="header.jsp" %>


        <div class=" row d-flex flex-row bd-highlight mb-3 course-content">
            <div class="d-flex flex-column bd-highlight mb-3 header-course">
                <div class="background-course">
                    <div class="header-component">
                        <div class=""><h1>${moduleDetail.moduleName}</h1></div>
                            <p>week number ${week.weekNumber}</p>
                            <p>week Title ${week.weekTilte}</p>
                            <p>week Description: ${week.weekDes}</p>
                            <a href="WeekDetail?wid=${week.weekId}">View Detail</a> &nbsp;
                            <a href="Add?wid=${week.weekId}">Add Quiz</a>&nbsp;
                            <a href="Add?wid=${week.weekId}">Add Lesson</a>&nbsp;
                            <a href="Add?wid=${week.weekId}">Add Assignment</a>
                            
                        </div>

                    </div>
                </div>

                <div class="button-enroll">
                    <a href="#">
                        <button class="style-button">Enroll</button>
                    </a>
                    <a href="AddWeek?moid=${moduleDetail.moduleId}">
                        <button class="style-button">Add Week</button>
                    </a>
                </div>


                <div class="course-description">
                    <!-- Display course details here -->
                    <div class="about-spec"><span>About this Course</span></div>

                    <div class="description">
                        <p>${moduleDetail.moduleDescription}</p>
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
                <h3 class="section-title">Syllabus - What you will learn from this course</h3>

                <div>
                    <c:forEach var="week" items="${listWeekCoursebyModuleId}" varStatus="loop">
                        <div class="div-module">
                            <div class="index-module">
                                <p class="name-module">${loop.index + 1} </p>
                            </div>
                            <div class="content-module">
                                <p class="name-module"><a href="WeekDetail?wid=${week.moduleId}">${week.weekTilte}</a> </p>
                                <p>Description: ${week.weekDes}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
