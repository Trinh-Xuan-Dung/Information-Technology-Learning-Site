<%-- 
    Document   : QuizMagement
    Created on : Jun 19, 2023, 8:14:41 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>



        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createquiz" data-bs-whatever="@mdo">Create quizz</button>
        <div class="modal fade" id="createquiz" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddQuiz" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Create Quiz</h5>
                            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="action" value="addweek">
                            <input type="hidden" name="weekid" value="${wid}">
                            <div class="form-group">
                                <label for="quizzName" class="col-form-label">Quiz name:</label>
                                <input type="text" name="QName" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="time" class="col-form-label">Time:</label>
                                <input type="number" name="Qtime" class="form-control"  value="15"  id="time" required>
                            </div>
                            <div class="form-group">
                                <label for="topicId" class="col-form-label">Topic:</label>
                                <input type="text" name="Qtopic" class="form-control"  required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <table class="table table-border">
            <thead>
            <th>id</th>
            <th>Name</th>
            <th>Topic</th>
            <th>Time</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach var="item" items="${quizs}">
                <tr>
                    <td>${item.quizId}</td>
                    <td>${item.quizName}</td>
                    <td>${item.quizTopic}</td>
                    <td>${item.quizTime}</td>
                    <td>
                        <a href="QuizDetail?qid=${item.quizId}">Detail</a>
                        <a href="#">Delete</a>
                        <a href="#">Edit</a>
                    </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>

</html>
