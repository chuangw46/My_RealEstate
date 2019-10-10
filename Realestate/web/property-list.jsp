<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="models.*" %>
<html>
<head>
    <title>My Real Estate - Property list</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-in/>
    <div class="container">
        <tags:flash-message/>
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">
            <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
                Published Property
            <% } else { %>
                Favourite properties
            <% } %>
            <i class="fas fa-list"></i>
            <small>List View</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item active">
                <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
                    Published Properties
                <% } else { %>
                    Favourite properties
                <% } %>
            </li>
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
                        <%  if (AppSession.getPropertyList() != null) {
                                ArrayList ps = (ArrayList) AppSession.getPropertyList();
                                for (int i=0; i<ps.size(); i++) {
                                    Property p = (Property) ps.get(i); %>
                            <tr>
                                <th scope="row"><%= i+1 %></th>
                                <td><%=p.getType()%> - <%= p.getRent_or_buy() %></td>
                                <td><%=p.retrieveTheAddressString()%></td>
                                <td><%=p.getPrice()%></td>
                                <td><%=p.getDate_available()%></td>
                                <td>
                                    <form method="post" action="frontServlet" class="form-inline">
                                        <a href="frontServlet?command=PropertyInfo&id=<%=p.getId()%>"
                                           class="btn btn-success btn-sm m-1" role="button">View</a>
                                        <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
                                        <a href="frontServlet?command=RedirectEditProperty&id=<%=p.getId()%>"
                                           class="btn btn-warning btn-sm m-1" role="button">Edit</a>

                                        <input type="hidden" id="command" name="command" value="DeleteProperty">
                                        <input type="hidden" id="property-id" name="property-id" value="<%=p.getId()%>">
                                        <button class="btn btn-danger btn-sm m-1" type="submit"
                                                onclick="return confirm('Are you sure you want to delete this property?')">Delete
                                        </button>
                                        <% } %>
                                    </form>
                                </td>
                            </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>

        <% if (AppSession.hasRole(AppSession.AGENT_ROLE)) { %>
        <div class="row mb-3">
            <form method="get" action="frontServlet">
                <input type="hidden" name="command" value="RedirectPublish">
                <div class="form-group col-lg">
                    <button class="btn btn-primary" type="submit">Publish a new property</button>
                </div>
            </form>
        </div>
        <% } %>

    </div>

    <tags:footer-copyright/>
    <script>
        if (window.history.replaceState) {
            window.history.replaceState(null, null, "frontServlet?command=ListProperties");
        }
    </script>
</body>
</html>
