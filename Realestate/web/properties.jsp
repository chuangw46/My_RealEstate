<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-10
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Real Estate - Properties</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/modern-business.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/c42c4fb0e2.js"></script>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <i class="fas fa-sign"></i>
                My Real Estate
            </a>

            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">About </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="properties.jsp">Buy </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="properties.jsp">Rent </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="properties.jsp">Find Agents </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile.jsp">Enquiries </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile.jsp">Username <i class="far fa-user-circle"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signin.jsp">
                            Sign in <i class="fas fa-sign-in-alt"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signup.jsp">
                            Join us
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Properties <i class="fas fa-building"></i>
<%--            <small>Subheading</small>--%>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="index.jsp">Home</a>
            </li>
            <li class="breadcrumb-item active">Properties</li>
        </ol>

        <!-- Image Header -->
        <img class="img-fluid rounded mb-4"
             src="./images/home-header.jpg" alt="Property Header">

        <hr>

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-4 mb-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="./images/yasmine-boheas-i_q8BWT80TE-unsplash.jpg" class="card-img-top" alt="Property Photo">
                    <div class="card-body">
                        <h5 class="card-title">Property Title 1</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="./images/siniz-kim-0vCHIpgLpco-unsplash.jpg" class="card-img-top" alt="Property Photo">
                    <div class="card-body">
                        <h5 class="card-title">Property Title 2</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="./images/neonbrand-kdwahpWYfQo-unsplash.jpg" class="card-img-top" alt="Property Photo">
                    <div class="card-body">
                        <h5 class="card-title">Property Title 3</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Learn More</a>
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

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Junhan Yang & Chuang Wang 2019</p>
        </div>
    </footer>
</body>
</html>
