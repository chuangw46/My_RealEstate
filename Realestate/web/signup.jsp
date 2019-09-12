<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-11
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Sign Up</title>
    <tags:head/>
</head>
<body class="bg-secondary">
    <div class="container">
        <div class="row">
            <div class="d-flex justify-content-center align-items-center container">
                <form method="post" action="frontServlet" class="bg-white p-5 shadow col-lg-6">
                    <input type="hidden" name="command" id="command" value="SignUp">
                    <a class="close bg-transparent float-lg-left" aria-label="Close" href="index.jsp">
                        <span aria-hidden="true">&times;</span>
                    </a>
                    <div class="text-center">
                        <p class="h2 text-info"><i class="fas fa-sign"></i>My Real Estate</p>
                    </div>
                    <p class="h4 p-3 font-weight-bolder">Sign Up</p>
                    <div class="form-group input-group col-lg-12">
                        <label for="email"></label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-envelope"></i></span>
                        </div>
                        <input type="email" class="form-control" id="email" aria-labelledby="email" placeholder="Email address" required>
                    </div>
                    <div class="form-group input-group col-lg-12">
                        <label for="email"></label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-user-circle"></i></span>
                        </div>
                        <input type="text" class="form-control" id="username" aria-labelledby="username" placeholder="Username" required>
                    </div>
                    <div class="form-group input-group col-lg-12">
                        <label for="password"></label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-unlock-alt"></i></span>
                        </div>
                        <input type="password" class="form-control" id="password" aria-labelledby="password" placeholder="Password" required>
                        <div class="input-group-append">
                            <button type="button" class="bg-transparent" id="show-hide" onclick="showOrHide()">
                                <i id="show-hide-icon" class="fas fa-eye-slash" style="color: red"></i>
                            </button>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-info col-lg-12">Sign Up</button>
                    <p class="p-3 font-weight-light">Already have an account? <a href="signin.jsp">Sign in.</a></p>

                    <hr>

                    <div class="text-center">
                        <small class="font-weight-light text-black-50">We value your privacy of personal information.</small>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    function showOrHide() {
        let x = document.getElementById("password");
        let icon = document.getElementById("show-hide-icon");
        if (x.type === "password") {
            x.type = "text";
            icon.style.color = 'black';
        } else {
            x.type = "password";
            icon.style.color = 'red';
        }
    }
</script>
</html>
