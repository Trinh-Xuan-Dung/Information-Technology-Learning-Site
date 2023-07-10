<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: Colorlib
Author URL: https://colorlib.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Register to join with ús</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="css/Register.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- //web font -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    </head>
    <body>
        <!-- main -->
        <div class="main-w3layouts wrapper">
            <h1>Register to join with ús</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <c:if test="${Message!=null}" >
                        <span id="duplicateuser" class="error text-danger co" style="color: red">${Message}</span>
                    </c:if>
                        <form class="pt-2" action="Register" method="post" onsubmit="return validateForm()">

                        <input class="text" type="text" name="Username" placeholder="Username" required="">
                        <input class="text email" type="email" name="email" placeholder="Email" required="">
                        <input class="text" type="password" id="password" name="password" placeholder="Password" required="">
                        <span style="color: red" id="passwordError" class="error"></span>
                        <input class="text w3lpass" type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required="">
                        <span style="color: red" id="confirmPasswordError" class="error"></span>
                        <div class="wthree-text">
                            <label class="anim">
                                <input type="checkbox" class="checkbox" required="">
                                <span>I Agree To The Terms & Conditions</span>
                            </label>
                            <div class="clear"> </div>
                        </div>
                        <input type="submit" value="SIGNUP">
                    </form>
                    <p>I have an Account? <a href="#"> Login Now!</a></p>
                </div>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>
            </div>
            <!-- //copyright -->
            <ul class="colorlib-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <script>
            function validateForm() {
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirmPassword").value;
                var passwordError = document.getElementById("passwordError");
                var confirmPasswordError = document.getElementById("confirmPasswordError");
                var passwordRegex = /^(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;

                if (!passwordRegex.test(password)) {
                    passwordError.innerHTML = "Password must be at least 8 characters long, contain at least 1 special character, and at least 1 uppercase character.";
                    return false;
                }

                if (password !== confirmPassword) {
                    confirmPasswordError.innerHTML = "Passwords do not match.";
                    return false;
                }

                passwordError.innerHTML = ""; // Clear the password error message if validation succeeds
                confirmPasswordError.innerHTML = ""; // Clear the confirm password error message if validation succeeds
                return true;
            }
        </script>
        <!-- //main -->
    </body>
</html>