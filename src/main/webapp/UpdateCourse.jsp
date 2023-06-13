<%-- 
    Document   : UpdateCourse
    Created on : Jun 6, 2023, 10:14:39 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Course</h1>
        <form action="UpdateCourse" method="post" id="myForm">
            <input name="courseidupdate" type="hidden" value="${courseId}"/>            
            <table border="1" style="border-collapse: collapse" >

                <tbody>
                    <tr>
                        <td>Course Name:</td>
                        <td><input type="type" name="coursenameupdate" value="${oldCourse.courseName}"></td>
                    </tr>
                    <tr>
                        <td>Course Image</td>
                        <td><input type="type" name="courseimageupdate" value="${oldCourse.imageUrlString}"></td>
                    </tr>
                    <tr>
                        <td>Course Subject</td>
                        <td><c:forEach var="subjectview" items="${listSubjectToView}">
                                <label>
                                    <input  type="checkbox" name="selectedSubjects" value="${subjectview.subjectId}"
                                           <c:forEach var="selectedSubject" items="${oldCourse.subjects}">
                                               <c:if test="${selectedSubject.subject.subjectId == subjectview.subjectId}">
                                                   checked
                                               </c:if>
                                           </c:forEach>
                                           />
                                    ${subjectview.subjectName}
                                </label>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td>Course Description</td>
                        <td><textarea id="id" name="courdescriptionupdate"   rows="5" cols="20">${oldCourse.courseDescription}</textarea></td>

                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>

                </tbody>
            </table>
        </form>
        <script>
        document.querySelector('#myForm').addEventListener('submit', function(event) {
            var checkboxes = document.querySelectorAll('input[name="selectedSubjects"]:checked');

            if (checkboxes.length === 0) {
                event.preventDefault(); // Prevent form submission
                alert('Please select at least one option.');
            }
        });
    </script>
    </body>
</html>
