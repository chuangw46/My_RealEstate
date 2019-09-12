<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Property list</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-out/>

    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Property <i class="fas fa-list"></i>
            <small>List View</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item active">List of Properties</li>
        </ol>

        <hr>

        <div class="row">
            <div class="col-lg-12 m-2">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Property Type</th>
                        <th scope="col">Address</th>
                        <th scope="col">Price</th>
                        <th scope="col">Available Date</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>House - Sell</td>
                        <td>888 Swanston Street, Carlton, VIC, Australia, 3033</td>
                        <td>$1,000,000</td>
                        <td>01/09/2019</td>
                        <td>
                            <div class="form-inline">
                                <a href="frontServlet?command=PropertyInfo" class="btn btn-success btn-sm mr-2" role="button">View</a>
                                <a href="frontServlet?command=PublishProperty&action=edit" class="btn btn-warning btn-sm mr-2" role="button">Edit</a>
                                <a href="frontServlet?command=PublishProperty&action=delete" class="btn btn-danger btn-sm" role="button">Delete</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Apartment & Unit - Rent</td>
                        <td>288 Queen Street, CBD, VIC, Australia, 3011</td>
                        <td>$450 PW</td>
                        <td>28/08/2019</td>
                        <td>
                            <div class="form-inline">
                                <a href="frontServlet?command=PropertyInfo" class="btn btn-success btn-sm mr-2" role="button">View</a>
                                <a href="frontServlet?command=PublishProperty&action=edit" class="btn btn-warning btn-sm mr-2" role="button">Edit</a>
                                <a href="frontServlet?command=PublishProperty&action=delete" class="btn btn-danger btn-sm" role="button">Delete</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Apartment & Unit - Rent</td>
                        <td>62 Little Collin Street, CBD, VIC, Australia, 3009</td>
                        <td>$375 PW</td>
                        <td>15/09/2019</td>
                        <td>
                            <div class="form-inline">
                                <a href="frontServlet?command=PropertyInfo" class="btn btn-success btn-sm mr-2" role="button">View</a>
                                <a href="frontServlet?command=PublishProperty&action=edit" class="btn btn-warning btn-sm mr-2" role="button">Edit</a>
                                <a href="frontServlet?command=PublishProperty&action=delete" class="btn btn-danger btn-sm" role="button">Delete</a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <tags:footer-copyright/>
</body>
</html>
