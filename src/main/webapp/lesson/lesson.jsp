<%-- 
    Document   : lesson
    Created on : Jul 11, 2023, 3:17:24 PM
    Author     : AAdmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/head.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lesson.css">
    </head>
    <body>
        <%@include file="/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 video-list">
                    <h4 class="mb-3">${weekToView.weekTilte}</h4>
                    <ul>
                        <c:forEach items="${listL}" var="lesson" >
                            <li onclick="playVideo('${lesson.videoPath}')">${lesson.title}</li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="col-md-8 video-player">
                    <div id="player"></div>
                </div>
            </div>
        </div>

        <script>
            // Thay đổi video hiển thị
            function playVideo(videoId) {
                var playerDiv = document.getElementById('player');

                // Xóa nội dung cũ của player
                playerDiv.innerHTML = '';

                // Tạo iframe nhúng video từ YouTube
                var iframe = document.createElement('iframe');
                iframe.src = 'https://www.youtube.com/embed/' + videoId;
                iframe.width = '100%';
                iframe.height = '400';
                iframe.allowFullscreen = true;

                // Thêm iframe vào player
                playerDiv.appendChild(iframe);
            }
        </script>
        <%@include file="/footer.jsp" %>
    </body>
</html>
