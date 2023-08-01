<%-- 
    Document   : Profile
    Created on : Jul 11, 2023, 2:46:05 PM
    Author     : hoanglong2310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/Profile.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/header.css"/>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>


        <div class="content container-fluid" id="content">
            <div class="row" id="all-row">
                <div class="left col-sm-3" id="col-sm-3">
                    <%@include file="SideMenu.jsp" %>
                </div>
                <div class="right col-sm-9" id="col-sm-9">
                    <div class="row">
                        <h2 style="color: rgb(0, 0, 0);">Thong tin ca nhan</h2>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="d-flex flex-column align-items-center text-center"><img class="rounded-circle"
                                                                                                    width="150px"
                                                                                                    src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                                </div>
                            </div>
                            <div class="col-md-2">
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">Ho va ten</span></li>
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">Email</span></li>
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">So dien thoai</span>
                                </li>
                                <li style="list-style: none; padding-bottom: 10px; "><span class="pr">Ngay sinh</span></li>
                                <li style="list-style: none; padding-bottom: 10px; "><span class="pr">Dia chi</span></li>

                            </div>
                            <div class="col-md-5">
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">${sessionScope.user.firstName} ${sessionScope.user.lastName}</span></li>
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">${sessionScope.user.email}</span></li>
                                <li style="list-style: none;padding-bottom: 10px;  "><span class="pr">${sessionScope.user.phone}</span></li>
                                <li style="list-style: none; padding-bottom: 10px; "><span class="pr">${sessionScope.user.dob}</span></li>
                                <li style="list-style: none; padding-bottom: 10px; "><span class="pr">${sessionScope.user.dob}</span></li>

                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <h2 style="color: rgb(0, 0, 0);">Chung chi</h2>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
    </body>
</html>
