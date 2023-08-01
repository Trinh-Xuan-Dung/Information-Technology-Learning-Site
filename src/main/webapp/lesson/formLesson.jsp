<%-- 
    Document   : formLesson
    Created on : Jul 12, 2023, 10:42:16 AM
    Author     : AAdmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/head.jsp" %>
    </head>
    <body>
        <%@include file="/header.jsp" %>
        <div class="container">
            <h1 class="mt-4">Create Lesson</h1>

            <form action="postLesson" method="post">
                <div class="mb-3">
                    <input type="hidden" class="form-control" id="weekId" name="weekId" value="${weekid}">
                </div>

                <div class="mb-3">
                    <label for="title" class="form-label">Title:</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>

                <div class="mb-3">
                    <label for="videoPath" class="form-label">Video Path:</label>
                    <input type="text" class="form-control" id="videoPath" name="videoPath" required>
                </div>

                <div class="mb-3">
                    <label for="script" class="form-label">Script:</label>
                    <textarea class="form-control" id="script" name="script" required></textarea>
                </div>

                <input class="btn btn-primary"  type="submit" value="Create Lesson">
            </form>
    </body>
</html>
