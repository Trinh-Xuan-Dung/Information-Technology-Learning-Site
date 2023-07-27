<%-- 
    Document   : ListAssigment
    Created on : Jul 27, 2023, 10:28:25 AM
    Author     : AAdmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="/share/error.jsp" %>
        <div class="container mt-4">
            <div class="row">
                <!-- Left column to display Assignment Titles -->
                <div class="col-md-4">
                    <h1 class="mb-4">Assignments</h1>
                    <ul class="list-group">
                        <c:forEach var="assignment" items="${assignments}">
                            <li class="list-group-item">
                                <button onclick="showDescription('${assignment.getAssignmentTitle()}', '${assignment.getDescription()}')"
                                   class="font-weight-bold">
                                    ${assignment.getAssignmentTitle()}
                                </button>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <!-- Right column to display Assignment Description -->
                <div class="col-md-8">
                    <h2>Description</h2>
                    <p id="description" class="border rounded p-2"></p>
                </div>
            </div>
        </div>



        <script>
            function showDescription(title, description) {
                document.getElementById("description").innerText = description;
            }
        </script>

        <%@include file="footer.jsp" %>
    </body>
</html>
