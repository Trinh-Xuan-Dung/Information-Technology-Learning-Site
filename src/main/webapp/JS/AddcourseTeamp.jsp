<%-- 
    Document   : AddcourseTeamp
    Created on : Jun 3, 2023, 3:35:42 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="path-to-javascript-file.js"></script>

    </head>
        <body>
        <h1>Add Course</h1>
        <form action="AddCourse" method="post">
            <table border="1" style="border-collapse: collapse" >

                <tbody>
                    <tr>
                        <td>Course Name:</td>
                        <td><input type="type" name="coursename"></td>
                    </tr>
                    <tr>
                        <td>Course Image</td>
                        <td><input type="type" name="courseimage"></td>
                    </tr>
                    <tr>
                        <td>Course Subject</td>
                        <td><select name="selectSubject">
                                <c:forEach var="Subject" items="${listSubjectToView}">
                                    <option value="${Subject.subjectId}">${Subject.subjectName}</option>
                                </c:forEach>
                            </select> </td>
                    </tr>
                    <tr>
                        <td>Course Description</td>
                        <td><textarea id="id" name="courdescription" rows="5" cols="20"></textarea></td>
                    </tr>
                    <tr>
                        <td>Add Module</td>
                        <td><input type="button" name="btnNewModule"  value="New Module" onclick="addModuleRow()">


                        </td>

                    </tr>


                </tbody>
            </table>
            <input type="submit" value="Add"/>

        </form>
        <script>
    function addModuleRow() {
        var table = document.querySelector("table"); // Get the table element
        var newRow = table.insertRow(-1); // Insert a new row at the last position (-1)

        var moduleNameCell1 = newRow.insertCell(0); // Insert a new cell for module name
        moduleNameCell1.innerHTML = '<p>Enter Name of Module </p>';
        var moduleNameCell2 = newRow.insertCell(1);
        moduleNameCell2.innerHTML = '<input type="text" name="moduleName">'; // Add an input field for module name
        var moduleNameCell3 = newRow.insertCell(2);
        moduleNameCell3.innerHTML = '<input type="button" name="btnnewWeek" value="New Week" onclick="addWeek(this)">';
    }

    function addWeek(button) {
        var moduleRow = button.parentNode.parentNode; // Get the module row
        var weekRow = moduleRow.insertAdjacentElement('afterend', document.createElement('tr')); // Insert a new row after the module row

        var weekCellEmpty = weekRow.insertCell(0); // Insert a new emtpty cell for week details
        

        var weekCell1 = weekRow.insertCell(1); // Insert a new cell for week details
        weekCell1.innerHTML = '<p>Enter Week Details</p>';

        var weekCell2 = weekRow.insertCell(2); // Insert a new cell for week input
        weekCell2.innerHTML = '<input type="text" name="weekName">'; // Add an input field for week name
    }
</script>
    </body>
</html>
