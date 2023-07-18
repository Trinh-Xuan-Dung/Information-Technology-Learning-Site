<%-- 
    Document   : formAssignment
    Created on : Jul 18, 2023, 8:46:02 PM
    Author     : AAdmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new a assignment</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formAssignment.css">
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="alert-container">
             <%
                String success = (String)request.getAttribute("successMessage");
                if (success != null && !success.isEmpty()) { 
            %>    
            <div class="alert alert-success">
                <strong>Success:</strong> ${successMessage}
            </div>
            <% }%>
        </div>
        
        <div class="alert-container">
             <%
                String error = (String)request.getAttribute("errorMessage");
                if (error != null && !error.isEmpty()) { 
            %>    
            <div class="alert alert-danger">
                <strong>Error:</strong> ${errorMessage}
            </div>
            <% }%>
        </div>

        <div class="container mt-4">
            <h2>Add Assignment</h2>
            <form method="post" action="postAssignment">
                <div class="form-group mt-4">
                    <input type="hidden" class="form-control" id="weekId" name="weekId" value="${weekid}">
                </div>
                <div class="form-group mt-4">
                    <label for="assignmentTitle">Assignment Title:</label>
                    <input type="text" class="form-control" id="assignmentTitle" name="assignmentTitle" maxlength="100" required>
                </div>
                <div class="form-group mt-4">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" rows="4" maxlength="500" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary mt-4">Add Assignment</button>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
