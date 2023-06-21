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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class=" ">
            <h4>Quiz Name :${quizView.quizName}</h4>
            <p>topic:${quizView.quizTopic}</p>
            <p>Time:${quizView.quizTime} min</p>

        </div>
        <form id="importFileForm" action="QuizDetail" method="post" enctype="multipart/form-data">
            <label for="file">Choose a file:</label>
            <input name="quizId" value="${quizView.quizId}" type="hidden">
            <input type="file" id="file" name="file">
            <input type="submit" name="upload" value="Upload">
        </form>

        <!--        <button>Add Question</button>-->
        <div class="table-container">
            <% int count = 0;%>    
            <c:forEach var="item" items="${qs}">
                <%  count++;%>
                <div class="row d-flex flex-column p-3">
                    <div class="cell">Q.<% out.println(count);%>:</div>
                    <div class="cell">Qest:${item.questContent}</div>
                    <div class="d-flex flex-row">
                        <div class="option">${item.optionA?null:item.optionA}</div>
                        <c:if test="${item.optionA!=null}">
                            <input type="checkbox" name="answerA" checked="${item.answerA=="false"?true:false}">${item.answerA}
                        </c:if>

                    </div>
                    <div class="d-flex flex-row">
                        <div class="option">${item.optionB?null:item.optionB}</div>
                        <c:if test="${item.optionB!=null}">
                            <input type="checkbox" name="answerB"   checked="${item.answerB=="false"?false:true}">
                        </c:if>

                    </div>
                    <div class="d-flex flex-row">
                        <div class="option">${item.optionC?null:item.optionC}</div>
                        <c:if test="${item.optionC!=null}">
                            <input type="checkbox" name="answerC" checked="${item.answerC=="false"?false:true}">
                        </c:if>

                    </div>
                    <div class="d-flex flex-row">
                        <div class="option">${item.optionD?null:item.optionD}</div>
                        <c:if test="${item.optionD!=null}">
                            <input type="checkbox" name="answerD" checked="${item.answerD=="false"?false:true}">
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
        <c:if test="${qs!=null}">
            <input type="submit" value="save" >                
        </c:if>
        <script>
            document.getElementById("importFileForm").addEventListener("submit", function (event) {
                var fileInput = document.getElementById("file");
                if (fileInput.files.length === 0) {
                    event.preventDefault(); // Prevent form submission
                    alert("Please choose a file.");
                }

                var file = fileInput.files[0];
                if (file && file.type === "text/plain") {
                    // File is a .txt format, proceed with form submission
                    // ...
                } else {
                    event.preventDefault(); // Prevent form submission
                    alert("Please choose a .txt file.");
                }
            });

        </script>

    </body>
</html>
