/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//document.getElementById('remember').onclick = function() {
//    document.getElementById('remember').parentElement.style.color = this.checked ? "#9A616D" : "";
//};

function validateForm() {
    var password = document.getElementById("password").value;
    var passwordBorder = document.getElementById("password");
    var passwordError = document.getElementById("passwordError");
    
    var passwordRegex = /^(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
    
    
    if (!passwordRegex.test(password)) {
        passwordBorder.style.borderBottom = "1px solid red";
        passwordError.innerHTML = "Password: At least 8 characters long</br>At least 1 special character</br>At least 1 uppercase character.";
        return false;
    }


    passwordError.innerHTML = ""; // Clear the password error message if validation succeeds
    return true;
}
