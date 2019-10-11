<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 11/10/19
  Time: 2:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page import="models.Agent" %>
<%@ page import="models.AgencyCompany" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Property" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Agent Profile</title>
    <tags:head/>
</head>
<body>
<tags:navbar-log-in/>
<div class="container">
    <tags:flash-message/>
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3 font-weight-light">
        Agent Profile <i class="fas fa-user-tie"></i>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="frontServlet?command=IndexPage">Home</a>
        </li>
        <li class="breadcrumb-item active">Agent Profile</li>
    </ol>
    <hr>
    <% Agent agent = (Agent) AppSession.getOtherUser(); %>
    <div class="row">
        <div class="col-lg-12">
            <h3 class="my-3 text-muted">
                Overview
            </h3>
            <hr>
            <ul class="text-black-50 font-weight-light">
                <li>Name: <%= agent.getName() %>
                </li>
                <li>Contact Information: <%= agent.getPhone() %>
                </li>
                <li>Biography: <%= agent.getBio() %>
                </li>
            </ul>
            <% AgencyCompany company = agent.getCompany(); %>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <h3 class="my-3 text-muted">Company Details</h3>
            <hr>
            <ul class="text-black-50 font-weight-light">
                <li>Name: <%= company.getName() %>
                </li>
                <li>Address: <%= company.getAddress() %>
                </li>
                <li>Website: <%= company.getWebsite() %>
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 m-2">
            <h3 class="my-3 text-muted">
                Properties under this agent
            </h3>
            <hr>
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
                <% if (AppSession.getPropertyList() != null && AppSession.getPropertyList().size() > 0) {
                    ArrayList ps = (ArrayList) AppSession.getPropertyList();
                    for (int i = 0; i < ps.size(); i++) {
                        Property p = (Property) ps.get(i); %>
                <tr>
                    <th scope="row"><%= i + 1 %>
                    </th>
                    <td><%=p.getType()%> - <%= p.getRent_or_buy() %>
                    </td>
                    <td><%=p.retrieveTheAddressString()%>
                    </td>
                    <td><%=p.getPrice()%>
                    </td>
                    <td><%=p.getDate_available()%>
                    </td>
                    <td>
                        <a href="frontServlet?command=PropertyInfo&id=<%=p.getId()%>"
                           class="btn btn-success btn-sm m-1" role="button">View</a>
                    </td>
                </tr>
                <% } %>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<tags:footer-copyright/>
</body>
</html>
