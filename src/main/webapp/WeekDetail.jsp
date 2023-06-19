<%-- 
    Document   : WeekDetail
    Created on : Jun 14, 2023, 12:08:40 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>JSP Page</title>
    </head>
    <body>

        <div class="d-flex flex-row">
            <div class="col-4">
                <div>
                    <h4>${weekToView.weekTilte}</h4>
                </div>
                <div class="col d-flex flex-row ">
                    <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Lesson</a>
                    <a type="button" class="btn btn-sm btn-outline-secondary" href="AddQuiz?wid=${weekToView.weekId}">View All Quiz</a>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Assignment</button>
                </div>

            </div>
            <div class="col-6">content of week here:contain tile of all component in week</div>
        </div>

    </body>
</html>
