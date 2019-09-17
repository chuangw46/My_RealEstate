<% if (request.getSession().getAttribute("alertMessage") != null) { %>
<div class="row justify-content-center">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <%=request.getSession().getAttribute("alertMessage")%>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<% request.getSession().removeAttribute("alertMessage"); } %>

<% if (request.getSession().getAttribute("infoMessage") != null) { %>
<div class="row justify-content-center">
    <div class="alert alert-info alert-dismissible fade show" role="alert">
        <%=request.getSession().getAttribute("infoMessage")%>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<% request.getSession().removeAttribute("infoMessage"); } %>

<% if (request.getSession().getAttribute("errorMessage") != null) { %>
<div class="row justify-content-center">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <%=request.getSession().getAttribute("errorMessage")%>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<% request.getSession().removeAttribute("errorMessage"); } %>

<% if (request.getSession().getAttribute("successMessage") != null) { %>
<div class="row justify-content-center">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <%=request.getSession().getAttribute("successMessage")%>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<% request.getSession().removeAttribute("successMessage"); } %>