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
        <form action="UpdateCourse" method="post">
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
                        <td><c:forEach var="subject" items="${listSubjectToView}">
                                <label>
                                    <input type="checkbox" name="selectedSubjects" value="${subject.subjectId}"
                                          <c:forEach var="selectedSubject" items="${listScSelected}">
                                               <c:if test="${selectedSubject.subjectId == subject.subjectId}">
                                                   checked
                                               </c:if>
                                           </c:forEach>
                                           />
                                    ${subject.subjectName}
                                </label>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td>Course Description</td>
                        <td><textarea id="id" name="courdescriptionupdate"   rows="5" cols="20"></textarea></td>
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
