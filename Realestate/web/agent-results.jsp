<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 11/10/19
  Time: 2:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="service.AppSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="models.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>My Real Estate - Agent list</title>
    <tags:head/>
</head>
<body>
<tags:navbar-log-in/>
<div class="container">
    <% if (AppSession.isAuthenticated()) { %>
    <tags:navbar-log-in/>
    <% } else { %>
    <tags:navbar-log-out/>
    <% } %>
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3 font-weight-light">Agents <i class="fas fa-user-tie"></i>
        <small>Search Results</small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="frontServlet?command=IndexPage">Home</a>
        </li>
        <li class="breadcrumb-item active">Search Results</li>
    </ol>

    <hr>

    <div class="row">
        <div class="col-lg-12 m-2">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Agent Name</th>
                    <th scope="col">Contact Information</th>
                    <th scope="col">Company Name</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% if (AppSession.getAgentList() != null && AppSession.getAgentList().size() > 0) {
                    ArrayList ul = (ArrayList) AppSession.getAgentList();
                    for (int i = 0; i < ul.size(); i++) {
                        Agent a = (Agent) ul.get(i); %>
                <tr>
                    <th scope="row"><%= i + 1 %>
                    </th>
                    <td><%=a.getName()%>
                    </td>
                    <td><%=a.getPhone() != null ? a.getPhone(): "N/A" %>
                    </td>
                    <td><%=a.getCompany().getName() != null ?
                            a.getCompany().getName() : "N/A" %>
                    </td>
                    <td>
                        <form method="post" action="frontServlet" class="form-inline">
                            <a href="frontServlet?command=ViewOthersProfile&id=<%= a.getId() %>"
                               class="btn btn-success btn-sm m-1" role="button">View</a>
                        </form>
                    </td>
                </tr>
                <% } %>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <br>

</div>

<tags:footer-copyright/>
<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, "frontServlet?command=ListProperties");
    }
</script>
</body>
</html>
