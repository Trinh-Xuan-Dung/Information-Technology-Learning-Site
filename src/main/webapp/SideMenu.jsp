<%-- 
    Document   : SideMenu
    Created on : Jul 11, 2023, 2:44:27 PM
    Author     : hoanglong2310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <style>
        #content {

            position: fixed;
            height: 100%;
        }

        #all-row {
            height: 100%;
        }


        #col-sm-9 {
        }

        .h2 {
            border-bottom: 1px solid white;
            text-align: center;
            padding-bottom: 20px;
            padding-top: 20px;
        }

        .row-1 {
            height: 100%;
            margin-left: 5px;
            margin-right: 5px;

        }

        .nav-link {
            color: white;
            font-size: 20px;
            padding-left: 30px;
        }

        .nav-link:hover {
            color: rgb(208, 208, 208);
        }

        .pr {
            padding-bottom: 20px;
        }
    </style>
    <body>
        <h2 class="h2" style="color: white;">Menu</h2>
        <div class="row-1">
            <li style="list-style: none;">
                <h4 style="color: white;">Quan ly khoa hoc</h4>
                <ul>
                    <li style="list-style: none;  "><a class="nav-link" href="#">Khoa hoc cua toi </a>
                    </li>
                </ul>
            </li>
            <li style="list-style: none;">
                <h4 style="color: white;">Quan ly tai khoan</h4>
                <ul>
                    <li style="list-style: none;  "><a class="nav-link" href="<%=request.getContextPath()%>/ProfileController">Thong tin tai khoan </a></li>
                    <li style="list-style: none;  "><a class="nav-link" href="#">Cap nhat tai khoan </a></li>
                </ul>
            </li>
        </div>
    </body>
</html>
