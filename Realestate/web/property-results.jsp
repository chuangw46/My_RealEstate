<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-10
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page import="models.Property" %>
<%@ page import="java.util.ArrayList" %>
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


        <%  if (AppSession.getPropertyList() != null && AppSession.getPropertyList().size() > 0) { %>
            <div class="row">
                <% ArrayList ps = (ArrayList) AppSession.getPropertyList();
                for (int i=0; i<ps.size(); i++) {
                Property p = (Property) ps.get(i); %>
                <div class="col-lg-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <%--show 6 different images iteratively--%>
                        <a href="#"><img class="card-img-top" src="
                        <% if (i%6 == 1) { %>
                        ./images/neonbrand-kdwahpWYfQo-unsplash.jpg
                        <% } else if (i%6 == 2) { %>
                        ./images/siniz-kim-0vCHIpgLpco-unsplash.jpg
                        <% } else if (i%6 == 3) { %>
                        ./images/yasmine-boheas-i_q8BWT80TE-unsplash.jpg
                        <% } else if (i%6 == 4) { %>
                        ./images/andrew-barrowman--kh2s5BdwxI-unsplash.jpg
                        <% } else if (i%6 == 5) { %>
                        ./images/elsa-noblet-5KD5PmZEfcg-unsplash.jpg
                        <% } else { %>
                        ./images/andre-francois-mckenzie-rz2YF0vBsvA-unsplash.jpg
                        <% } %>
                            " alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="frontServlet?command=PropertyInfo&id=<%= p.getId()%>"><%=
                                p.retrieveTheAddressString()%></a>
                            </h4>
                            <p class="card-text">
                                Type: <%= p.getType()%> - <%= p.getRent_or_buy()%> <br>
                                Price: <%= p.getPrice()%> <br>
                                Inspection Date: <%= p.getDate_inspection()%>
                                Available Date: <%= p.getDate_available()%>
                            </p>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
            <div class="row d-flex justify-content-center text-center">
                <h5 class="text-muted font-weight-lighter"> end of the results </h5>
            </div>
            <hr>
        <% } else {%>
            <div class="row d-flex justify-content-center text-center">
                <h5 class="text-muted font-weight-lighter"> Sorry, no results are found </h5>
            </div>
        <% } %>
        <br>

<%--        <div class="row d-flex justify-content-center">--%>
<%--            <nav aria-label="Page navigation example">--%>
<%--                <ul class="pagination">--%>
<%--                    <li class="page-item">--%>
<%--                        <a class="page-link" href="#" aria-label="Previous">--%>
<%--                            <span aria-hidden="true">&laquo;</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                    <li class="page-item">--%>
<%--                        <a class="page-link" href="#" aria-label="Next">--%>
<%--                            <span aria-hidden="true">&raquo;</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </nav>--%>
<%--        </div>--%>
    </div>

    <tags:footer-copyright/>
</body>
</html>
