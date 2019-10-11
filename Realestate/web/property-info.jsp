<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Property" %>
<%@ page import="service.AppSession" %>
<%@ page import="models.Agent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Property Information</title>
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
        <small>Information</small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="frontServlet?command=IndexPage">Home</a>
        </li>
        <li class="breadcrumb-item active">Property Information</li>
    </ol>

    <hr>
    <div class="row">
        <div class="col-lg-8">
            <img class="img-fluid" src="./images/andre-francois-mckenzie-rz2YF0vBsvA-unsplash.jpg" alt="main photo">
        </div>

        <div class="col-lg-4">
            <h3 class="my-3 text-muted">Property Description</h3>
            <ul class="text-black-50 font-weight-light">
                <li>${currentProperty.description}</li>
            </ul>
            <h3 class="my-3 text-muted">Property Details</h3>
            <ul class="text-black-50 font-weight-light">
                <li>Type: ${currentProperty.type} - ${currentProperty.rent_or_buy}</li>
                <li>Address: <%= AppSession.getProperty().retrieveTheAddressString() %>
                </li>
                <li>Inspection Date: ${currentProperty.date_inspection}</li>
                <li>Available Date: ${currentProperty.date_available}</li>
                <li>Price: ${currentProperty.price}</li>
                <li><i class="fas fa-bed"></i> ${currentProperty.num_bed}
                    <i class="fas fa-bath"></i> ${currentProperty.num_bath}
                    <i class="fas fa-car-side"></i> ${currentProperty.num_carpark} </li>
            </ul>
            <% if (!AppSession.hasRole(AppSession.AGENT_ROLE) && AppSession.getOtherUser() != null) { %>
            <% Agent a = (Agent) AppSession.getOtherUser(); %>
            <h3 class="my-3 text-muted">Agent Information</h3>
            <ul class="text-black-50 font-weight-light">
                <li>Name:
                    <a href="frontServlet?command=ViewOthersProfile&id=<%= a.getId() %>">
                        <%= a.getName() %>
                    </a>
                </li>
                <li>Contact Information: <%= a.getPhone() %></li>
            </ul>
            <% } %>
            <% if (AppSession.hasRole(AppSession.CLIENT_ROLE)) { %>
                <% if (AppSession.getLikeProperty()) { %>
                    <a href="frontServlet?command=LikeProperty?id=${currentProperty.id}">
                        <i class="fas fa-star fa-3x"></i> Like
                    </a>
                <% } else { %>
                    <a href="frontServlet?command=UnlikeProperty?id=${currentProperty.id}">
                        <i class="far fa-star fa-3x"></i> Like
                    </a>
                <% } %>
            <% } %>
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
    <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
    <div class="row mb-3">
        <a href="frontServlet?command=RedirectEditProperty&id=${currentProperty.id}"
           class="btn btn-warning m-3" role="button">Update details</a>
    </div>
    <% } %>
</div>

<tags:footer-copyright/>
</body>
</html>
