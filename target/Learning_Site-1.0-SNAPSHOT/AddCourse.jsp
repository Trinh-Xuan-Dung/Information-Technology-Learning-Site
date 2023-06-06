<%-- 
    Document   : AddCourse
    Created on : May 31, 2023, 3:14:10 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course Page</title>
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
                        <td><c:forEach var="subject" items="${listSubjectToView}">
                                <label>
                                    <input type="checkbox" name="selectedSubjects" value="${subject.subjectId}" />
                                    ${subject.subjectName}
                                </label>
                            </c:forEach> </td>
                    </tr>
                    <tr>
                        <td>Course Description</td>
                        <td><textarea id="id" name="courdescription" rows="5" cols="20"></textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Add"/></td>
                    </tr>

                </tbody>
            </table>
        </form>
    </body>
</html>
