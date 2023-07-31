<%-- 
    Document   : UpdateAssignment
    Created on : Jul 25, 2023, 9:51:24 PM
    Author     : Hoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formAssignment.css">
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
                    <form method="post" action="UpdateAssignment">
                <div class="form-group mt-4">
                    <input type="hidden" class="form-control" id="weekId" name="weekId" value="${ass.getWeekId()}">
                    <input type="hidden" class="form-control" id="assignmentId" name="assignmentId" value="${ass.getAssignmentId()}">
                </div>
                <div class="form-group mt-4">
                    <label for="assignmentTitle">Assignment Title:</label>
                    <input type="text" class="form-control" id="assignmentTitle" name="assignmentTitle" value="${ass.getAssignmentTitle()}" maxlength="100" required>
                </div>
                <div class="form-group mt-4">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" rows="4" maxlength="500" required>${ass.getDescription()}</textarea>
                </div>
                <button type="submit" class="btn btn-primary mt-4">Update Assignment</button>
            </form>
                <%@include file="footer.jsp" %>
    </body>
</html>
