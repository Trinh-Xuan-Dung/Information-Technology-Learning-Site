<%-- 
    Document   : QuizDetail
    Created on : Jun 19, 2023, 11:08:07 PM
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
        <div class="d-inline-flex flex-row ">
            <h4>Quiz Name :${quizView.quizName}</h4>
            <p>topic:${quizView.quizTopic}</p>
            <p>Time:${quizView.quizTime} min</p>

        </div>
        <form action="QuizDetail" method="post" enctype="multipart/form-data">
            <label for="file">Choose a file:</label>
            <input type="file" id="file" name="file">
            <input type="submit" value="Upload">
        </form>
      
        <button>Add Question</button>

    </body>
</html>
