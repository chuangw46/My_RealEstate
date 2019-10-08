<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-10
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
    <title>Real Estate - Properties</title>
    <tags:head/>
</head>
<body>
    <% if (AppSession.isAuthenticated()) { %>
    <tags:navbar-log-in/>
    <% } else { %>
    <tags:navbar-log-out/>
    <% } %>
    <div class="container">
        <tags:flash-message/>
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Property <i class="fas fa-building"></i>
            <small>Search Results</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item active">Search Results</li>
        </ol>

        <!-- Image Header -->
        <img class="img-fluid rounded mb-4"
             src="./images/home-header.jpg" alt="Property Header">

        <hr>

        <div class="row">
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/neonbrand-kdwahpWYfQo-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 1</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/siniz-kim-0vCHIpgLpco-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 2</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/yasmine-boheas-i_q8BWT80TE-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 3</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/andrew-barrowman--kh2s5BdwxI-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 4</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/elsa-noblet-5KD5PmZEfcg-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 5</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="./images/andre-francois-mckenzie-rz2YF0vBsvA-unsplash.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="frontServlet?command=PropertyInfo">Property Title 6</a>
                        </h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
                    </div>
                </div>
            </div>
        </div>

        <hr>

        <div class="row d-flex justify-content-center">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

    <tags:footer-copyright/>
</body>
</html>
