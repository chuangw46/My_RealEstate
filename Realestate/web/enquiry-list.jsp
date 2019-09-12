<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - My Enquiries</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-out/>

    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">My Enquiries <i class="fas fa-satellite-dish"></i>
            <small>List View</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item active">My Enquiries</li>
        </ol>

        <hr>

        <div class="row">
        </div>
    </div>
    <tags:footer-copyright/>
</body>
</html>
