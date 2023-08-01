<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #9A616D">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" style="color: white">Logo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a style="color: white;" class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/HomeController">Home</a>
                </li>
                <li class="nav-item">
                    <a  style="color: white;" class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" style="color: white;" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button id="seacrh" class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </li>
            </ul>

            <c:if test="${user == null}">
                <a class="sign" style="padding-right: 20px;" href="Register.jsp">Sign up</a>
                <span style="color: white;">|</span>
                <a class="sign" style="padding-left: 20px;" href="Login.jsp">Sign in</a>
            </c:if>
            <c:if test="${user != null}">
                <div>
                    <a style="color: white" href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">${sessionScope.user.firstName} ${sessionScope.user.lastName}</a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a href="ProfileController" class="dropdown-item">Profile</a>
                        <a href="#" class="dropdown-item">Report</a>
                        <div class="dropdown-divider"></div>
                        <a href="<%=request.getContextPath()%>/LogOutController" class="dropdown-item">Logout</a>
                    </div>
                </div>
            </c:if>  
        </div>
    </div>
</nav>
