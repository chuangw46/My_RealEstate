<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - My Profile</title>
    <tags:head/>
</head>
<body>
<tags:navbar-log-in/>
<div class="container">
    <tags:flash-message/>
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
                    <form id="buyer-properties-form" method="get" action="frontServlet">
                        <input type="hidden" name="command" value="ListProperties">
                        <button class="btn btn-info" type="submit"
                                <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
                                disabled
                                <% }%>>My favourite properties
                        </button>
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
                    <form id="tenant-properties-form" method="get" action="frontServlet">
                        <input type="hidden" name="command" value="ListProperties">
                        <button class="btn btn-info" type="submit"
                                <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
                                disabled
                                <% }%>>My favourite properties
                        </button>
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
                        <input type="hidden" name="command" value="ListProperties">
                        <button class="btn btn-info mt-1" type="submit"
                                <% if (AppSession.hasRole(AppSession.CLIENT_ROLE)) { %>
                                disabled
                                <% }%>>My published properties
                        </button>
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

    <form action="frontServlet" method="post">
        <input type="hidden" id="command" name="command" value="UpdateProfile">
        <div class="row">
            <div class="col">
                <p class="h5 font-weight-light text-black-50">Your full name</p>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-3">
                <label for="name"></label>
                <input id="name" name="name" type="text" class="form-control" placeholder="Full name"
                       value="${currentUser.name}">
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
                <input id="email" name="email" type='email' placeholder="XXX@XXX" class="form-control"
                       value="${currentUser.email}" disabled/>
            </div>
        </div>
        <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
        <div class="row">
            <div class="col">
                <p class="h5 font-weight-light text-black-50">Your contact number</p>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="phone"></label>
                <input id="phone" name="phone" type='text' placeholder="Your mobile number" class="form-control"
                       value="${currentUser.phone}"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="h5 font-weight-light text-black-50">Company name</p>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="company-name"></label>
                <input id="company-name" name="company-name" type='text' placeholder="Who do you work for?"
                       class="form-control" value="${currentUser.company.name}"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="h5 font-weight-light text-black-50">Company address</p>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="company-address"></label>
                <input id="company-address" name="company-address" type='text'
                       placeholder="Where is your company located?"
                       class="form-control" value="${currentUser.company.address}"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="h5 font-weight-light text-black-50">Company website</p>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="company-website"></label>
                <input id="company-website" name="company-website" type='text'
                       placeholder="Does you company have a website?"
                       class="form-control" value="${currentUser.company.website}"/>
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
                <textarea id="biography" name="biography" placeholder="Tell something about yourself"
                          class="form-control">${currentUser.bio}</textarea>
            </div>
        </div>
        <% } %>
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
