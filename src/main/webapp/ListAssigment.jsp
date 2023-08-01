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
                    <ul class="list-group" id="assignmentList">

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
            var raw_assignments = ${assignments};

            // Iterate over the "assignments" collection on the server-side




            function generateAssignmentList() {
                const assignmentList = document.getElementById("assignmentList");
                const wid = ${wid != null ? wid : 0 };
                raw_assignments.forEach((assignment) => {
                    const listItem = document.createElement("li");
                    listItem.classList.add("list-group-item");


                    // Create the button for assignment title
                    const button = document.createElement("button");
                    button.classList.add("font-weight-bold");
                    button.innerText = assignment.assignmentTitle;
                    button.addEventListener("click", () => showDescription(assignment.assignmentTitle, assignment.description));

                    // Append the button to the list item
                    listItem.appendChild(button);

                    // Append the list item to the assignmentList
                    assignmentList.appendChild(listItem);
                    
                    
                    // Create the anchor element for the icon
                    const iconLink = document.createElement("a");
                    iconLink.href = "${pageContext.request.contextPath}/UpdateAssignment?weekId="+ wid +"&assignmentId="+assignment.assignmentId; // Replace "#" with the appropriate link for the "update" action

                    // Create the icon element and add necessary classes
                    const icon = document.createElement("i");
                    icon.classList.add("fas", "fa-pencil-alt", "mr-2"); // Assuming "fa-pencil-alt" is the class for the "update" icon in Font Awesome

                    // Append the icon to the anchor element
                    iconLink.appendChild(icon);

                    // Append the anchor element to the list item
                    listItem.appendChild(iconLink);
                });
            }

            // Function to show the assignment description
            function showDescription(title, description) {
                const descriptionParagraph = document.getElementById("description");
                descriptionParagraph.innerText = description;
            }

            // Call the function to generate the assignment list on page load
            generateAssignmentList();
        </script>

        <%@include file="footer.jsp" %>
    </body>
</html>
