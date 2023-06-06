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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class=" row d-flex flex-row bd-highlight mb-3">
            <div class="col-8 p-2  d-flex flex-column justify-content-center align-items-center">
                <h1>${moduleDetail.moduleName} Detail</h1>
                <div class="grid-item">
                    <!-- Display course details here -->
                    <h2>ID:${moduleDetail.moduleId}</h2>
                    <h2> Name: ${moduleDetail.moduleName}</h2>
                    <p> Des: ${moduleDetail.moduleDescription}</p>
                    <!-- Add more fields as needed -->

 
                </div>
                
                <a href="AddWeek?moid=${moduleDetail.moduleId}">Add Week</a>
               
                <hr><!-- comment -->
                <h3>List of Week in module Here</h3>

                <div>
                    <c:forEach var="week" items="${listWeekCoursebyModuleId}">
                        <div>

                            <p>Module Name: ${week.weekNumber}</p>
                            <p>Module Description: ${week.weekTilte}</p>
                            <p>Module Description: ${week.weekDes}</p>
                            <a href="WeekDetails?mid=${week.weekId}">See all </a>
                            <a href="Add?mid=${week.weekId}">Add Quiz</a>
                            <a href="Add?mid=${week.weekId}">Add Lesson</a>
                            <a href="Add?mid=${week.weekId}">Add Assignment</a>
                            
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
