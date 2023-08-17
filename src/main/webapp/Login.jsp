<%-- 
    Document   : Login
    Created on : Jun 19, 2023, 1:06:25 PM
    Author     : hoanglong2310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
        <script src="code.jquery.com/jquery-1.11.1.min.js"></script>

        <script src="https://kit.fontawesome.com/f0969f1fb5.js" crossorigin="anonymous"></script>
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/sLogin.css">

    </head>

    <body>
        <input type="hidden" id="status" value="<%=request.getAttribute("status")%>"/>
        <div class="main" style="background: #9A616D">
            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure>
                                <img src="images/signin-image.jpg" alt="sing up image">
                            </figure>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Sign in</h2>
                            <form method="post" action="LoginController" class="register-form"
                                  id="login-form">
                                <div class="form-group">
                                    <span style="color: red" id="message">${MESSAGE}</span>
                                    <!--<span style="color: red; font-size: 11px; margin-top: 50px" id="passwordError" class="error"></span>-->
                                </div>
                                <div class="form-group">
                                    <label for="username"><i class="fas fa-user"></i></label> <input
                                        type="text" name="username" id="username"
                                        placeholder="Your Name" />
                                </div>
                                <div class="form-group">
                                    <label for="password"><i class="fa-solid fa-lock"></i></label> <input
                                        type="password" name="password" id="password"
                                        placeholder="Password" />

                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="remember" id="remember"
                                           class="agree-term"/> <label for="remember-me"
                                           class="label-agree-term"><span><span></span></span>Remember
                                        me</label>
                                </div>
                                <div class="form-group">
                                    <span>Forgot password </span><a href="ForgotPassword.jsp" style="color: blue;">click here!</a>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin"
                                           class="form-submit" value="Log in" style="background: #9A616D" />
                                </div>
                            </form>
                            <div class="social-login">
                                <a href="Register.jsp" class="signup-image-link">Create an
                                    account</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="JS/Login.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
                                      var status = document.getElementById("status").value;
                                      if (status === "resetSuccess") {
                                          Swal.fire({
                                              title: 'Congratulations!',
                                              text: 'Password reset successful',
                                              icon: 'success',
                                              confirmButtonText: 'OK'
                                          });
                                      } else if (status === "resetFailed") {
                                          Swal.fire({
                                              title: 'Error!',
                                              text: 'Password reset failed',
                                              icon: 'error',
                                              confirmButtonText: 'OK'
                                          });
                                      }
        </script>
    </body>

</html>
