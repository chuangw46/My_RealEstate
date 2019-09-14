<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Property Information</title>
    <tags:head/>
</head>
<body>
    <% if (request.getSession().getAttribute("currentUser") != null) { %>
    <tags:navbar-log-in/>
    <% } else { %>
    <tags:navbar-log-out/>
    <% } %>
    <div class="container">
        <tags:flash-message/>
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Property  <i class="fas fa-building"></i>
            <small>Information</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
<%--            <li class="breadcrumb-item">--%>
<%--                <a href="frontServlet?command=ListProperties">List of Properties</a>--%>
<%--            </li>--%>
            <li class="breadcrumb-item active">Property Information</li>
        </ol>

        <hr>

        <div class="row">
            <div class="col-lg-8">
                <img class="img-fluid" src="./images/andre-francois-mckenzie-rz2YF0vBsvA-unsplash.jpg" alt="main photo">
            </div>

            <div class="col-lg-4">
                <h3 class="my-3 text-muted">Property Description</h3>
                <p class="font-weight-light text-black-50">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.
                </p>
                <h3 class="my-3 text-muted">Property Details</h3>
                <ul class="text-black-50 font-weight-light">
                    <li>Type: House - Sell</li>
                    <li>Address: 888 Swanston Street, Carlton, VIC, Australia, 3033</li>
                    <li>Inspection Date: 18/09/2019</li>
                    <li>Available Date: 01/09/2019</li>
                    <li>Price: $1,000,000</li>
                    <li><i class="fas fa-bed"></i> 3; <i class="fas fa-bath"></i> 2; <i class="fas fa-car-side"></i> 1.</li>
                </ul>
            </div>
        </div>

        <h3 class="my-3 text-muted">More Photos</h3>
        <hr>
        <div class="row">
            <div class="col-md-3 col-sm-6 mb-4">
                <a href="#">
                    <img class="img-fluid" src="./images/elsa-noblet-5KD5PmZEfcg-unsplash.jpg" alt="photo1">
                </a>
            </div>
            <div class="col-md-3 col-sm-6 mb-4">
                <a href="#">
                    <img class="img-fluid" src="./images/andrew-barrowman--kh2s5BdwxI-unsplash.jpg" alt="photo2">
                </a>
            </div>
            <div class="col-md-3 col-sm-6 mb-4">
                <a href="#">
                    <img class="img-fluid" src="./images/siniz-kim-0vCHIpgLpco-unsplash.jpg" alt="photo3">
                </a>
            </div>
            <div class="col-md-3 col-sm-6 mb-4">
                <a href="#">
                    <img class="img-fluid" src="./images/yasmine-boheas-i_q8BWT80TE-unsplash.jpg" alt="photo4">
                </a>
            </div>
        </div>
    </div>

    <tags:footer-copyright/>
</body>
</html>
