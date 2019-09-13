<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - My Profile</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-out/>

    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">My Profile <i class="fas fa-users-cog"></i>
            <small>Manage profile</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
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
                        <form method="get" action="frontServlet">
                            <input type="hidden" id="command" name="command" value="ListProperties">
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


    <tags:footer-copyright/>
</body>
</html>
