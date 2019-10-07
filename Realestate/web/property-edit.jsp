<%@ page import="model.Property" %><%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="model.*" %>
<html>
<head>
    <title>My Real Estate - Update property details</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-in/>
    <div class="container">
        <tags:flash-message/>
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Property <i class="fas fa-share-alt"></i>
            <small>Publish New</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item">
                <a href="frontServlet?command=ListProperties">Published Properties</a>
            </li>
            <li class="breadcrumb-item active">Publish a Property</li>
        </ol>

        <hr>
        <% Property p = (Property) request.getSession().getAttribute("currentProperty");%>
        <form method="post" action="frontServlet">
            <input type="hidden" id="command" name="command" value="PublishProperty">
            <input type="hidden" id="action" name="action" value="Edit">
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Property Address</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-4">
                    <label for="street"></label>
                    <input id="street" name="street" type="text" class="form-control"
                           placeholder="Street number and name" value="<%=p.retrieveTheAddressObj().getStreet()%>" required>
                </div>
                <div class="form-group col-lg-2">
                    <label for="city"></label>
                    <input id="city" name="city" type="text" class="form-control"
                           placeholder="City" value="<%=p.retrieveTheAddressObj().getCity()%>" required>
                </div>
                <div class="form-group col-lg-2">
                    <label for="state"></label>
                    <input id="state" name="state" type="text" class="form-control"
                           placeholder="State" value="<%=p.retrieveTheAddressObj().getState()%>" required>
                </div>
                <div class="form-group col-lg-2">
                    <label for="country"></label>
                    <input id="country" name="country" type="text" class="form-control"
                           placeholder="Country" value="<%=p.retrieveTheAddressObj().getCountry()%>" required>
                </div>
                <div class="form-group col-lg-2">
                    <label for="post-code"></label>
                    <input id="post-code" name="post-code" type="number" class="form-control"
                           placeholder="Post code" value="<%=p.retrieveTheAddressObj().getPostal_code()%>" required>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Property Type</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-6">
                    <select class="custom-select" id="type" name="type" aria-label="Property Type" required>
                        <option >Choose Property Type</option>
                        <option value="House" <% if (p.getType().equals("House")) { %> selected <% } %>>House</option>
                        <option value="Apartment & Unit"<% if (p.getType().equals("Apartment & Unit")) { %> selected <% } %>>Apartment & Unit</option>
                        <option value="Town House"<% if (p.getType().equals("Town House")) { %> selected <% } %>>Town House</option>
                        <option value="Villa"<% if (p.getType().equals("Villa")) { %> selected <% } %>>Villa</option>
                        <option value="Land"<% if (p.getType().equals("Land")) { %> selected <% } %>>Land</option>
                        <option value="Acreage"<% if (p.getType().equals("Acreage")) { %> selected <% } %>>Acreage</option>
                        <option value="Rural"<% if (p.getType().equals("Rural")) { %> selected <% } %>>Rural</option>
                        <option value="Block of Units"<% if (p.getType().equals("Block of Units")) { %> selected <% } %>>Block of Units</option>
                        <option value="Retirement Living"<% if (p.getType().equals("Retirement Living")) { %> selected <% } %>>Retirement Living</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Rent or Sell</p>
                </div>
            </div>
            <div class="row mb-3">
                <div class="input-group col-lg-5">
                    <label for="price"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-dollar-sign"></i></span>
                    </div>
                    <input id="price" name="price" type="number" class="form-control"
                           placeholder="Renting or selling price" max="999999999" value="${currentProperty.price}"
                           required>
                </div>
                <div class="input-group col-lg-4">
                    <select class="custom-select" id="rent-sell" name="rent-sell" aria-label="Property Type" required>
                        <option >Choose..</option>
                        <option value="Rent" <% if (p.getRent_or_buy().equals("Rent")) { %> selected <% } %>>Rent</option>
                        <option value="Sell" <% if (p.getRent_or_buy().equals("Sell")) { %> selected <% } %>>Sell</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Room Structure</p>
                </div>
            </div>
            <div class="row mb-3">
                <div class="input-group col-lg-3">
                    <label for="bed-num"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-bed"></i></span>
                    </div>
                    <input id="bed-num" name="bed-num" type="number" class="form-control" placeholder="Number of bedrooms"
                           value="${currentProperty.num_bed}" required>
                </div>
                <div class="input-group col-lg-3">
                    <label for="bath-num"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-bath"></i></span>
                    </div>
                    <input id="bath-num" name="bath-num" type="number" class="form-control"
                           placeholder="Number of bathrooms" value="${currentProperty.num_bath}" required>
                </div>
                <div class="input-group col-lg-3">
                    <label for="car-park-num"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-car-side"></i></span>
                    </div>
                    <input id="car-park-num" name="car-park-num" type="number" class="form-control"
                           placeholder="Number of car parks" value="${currentProperty.num_carpark}" required>
                </div>
            </div>

            <div class="row mb-3">
                <div class="form-group col-lg-4">
                    <label for="inspection-date"></label>
                    <p class="h5 font-weight-light text-black-50">Inspection date</p>
                    <input id="inspection-date" name="inspection-date" type="date" class="form-control"
                           placeholder="Inspection date" value="${currentProperty.date_inspection}" required>
                </div>
                <div class="form-group col-lg-4">
                    <label for="available-date"></label>
                    <p class="h5 font-weight-light text-black-50">Available date</p>
                    <input id="available-date" name="available-date" type="date" class="form-control"
                           placeholder="Available date" value="${currentProperty.date_available}" required>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-lg-10">
                    <p class="h5 font-weight-light text-black-50">Additional Description (Optional)</p>
                    <textarea id="description" name="description" type="text" class="form-control"
                              placeholder="Give some more information."
                              maxlength="100">${currentProperty.description}</textarea>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-lg-10">
                    <div class="form-group">
                        <p class="h5 font-weight-light text-black-50">Upload Photos</p>
                        <p><small class="text-muted">Select multiple files by pressing Ctrl</small></p>
                        <input id="photos" name="photos" type="file" multiple>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <div class="form-group col-lg">
                    <button class="btn btn-primary" type="submit">Save changes</button>
                </div>
            </div>
        </form>
    </div>

    <tags:footer-copyright/>
    <script>

    </script>
</body>
</html>
