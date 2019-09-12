<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Real Estate - My Profile</title>
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
        <h1 class="mt-4 mb-3 font-weight-light">My Profile <i class="fas fa-users-cog"></i>
        <%--            <small>Subheading</small>--%>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="index.jsp">Home</a>
            </li>
            <li class="breadcrumb-item active">My Profile</li>
        </ol>

        <hr>

        <div class="row">
            <div class="col-lg-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="images/dmitry-demidko-eBWzFKahEaU-unsplash.jpg" class="card-img-top" alt="Agent picture">
                    <div class="card-body">
                        <h5 class="card-title">Buyer</h5>
                        <p class="card-text">
                            I want to check out properties that are marked in my favourite list.
                        </p>
                    </div>
                    <div class="card-footer text-center">
                        <form id="buyer-properties-form">
                            <button class="btn btn-info" type="submit" disabled>My favourite properties</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="images/nordwood-themes-bJjsKbToY34-unsplash.jpg" class="card-img-top" alt="Agent picture">
                    <div class="card-body">
                        <h5 class="card-title">Tenant</h5>
                        <p class="card-text">
                            I want to check out properties that are marked in my favourite list.
                        </p>
                    </div>
                    <div class="card-footer text-center">
                        <form id="tenant-properties-form">
                            <button class="btn btn-info" type="submit" disabled>My favourite properties</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="images/kobu-agency-7okkFhxrxNw-unsplash.jpg" class="card-img-top" alt="Agent picture">
                    <div class="card-body">
                        <h5 class="card-title">Agent</h5>
                        <p class="card-text">
                            I want to publish some properties on this website.
                        </p>
                    </div>
                    <div class="card-footer text-center">
                        <form id="agent-properties-form">
                            <button class="btn btn-info mt-1" type="submit">My published properties</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <hr>

        <div class="row">
            <div class="col-lg-12 p-3 text-center">
                <p class="h3 font-weight-light ">Your details</p>
            </div>
        </div>

        <form>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your name</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-3">
                    <label for="first-name"></label>
                    <input id="first-name" type="text" class="form-control" placeholder="First name">
                </div>
                <div class="form-group col-lg-3">
                    <label for="middle-name"></label>
                    <input id="middle-name" type="text" class="form-control" placeholder="Middle name">
                </div>
                <div class="form-group col-lg-3">
                    <label for="last-name"></label>
                    <input id="last-name" type="text" class="form-control" placeholder="Last name">
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your username</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-5">
                    <label for="username"></label>
                    <input id="username" type='text' placeholder="Your displayed name" class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your email</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-5">
                    <label for="email"></label>
                    <input id="email" type='email' placeholder="XXX@XXX" class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your date of birth</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-5">
                    <label for="date-of-birth"></label>
                    <input id="date-of-birth" type='date' placeholder="YYYY/MM/DD" class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your contact number</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-5">
                    <label for="number"></label>
                    <input id="number" type='number' placeholder="Your mobile number" class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Your biography</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-10">
                    <label for="biography"></label>
                    <textarea id="biography" placeholder="Tell something about yourself" class="form-control"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg">
                    <button class="btn btn-primary" type="submit">Save changes</button>
                </div>
            </div>
        </form>
    </div>


    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Junhan Yang & Chuang Wang 2019</p>
        </div>
    </footer>
</body>
</html>
