<%--
  Created by IntelliJ IDEA.
  User: junhanyang
  Date: 2019-09-12
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>My Real Estate - Publish a property</title>
    <tags:head/>
</head>
<body>
    <tags:navbar-log-out/>

    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3 font-weight-light">Property <i class="fas fa-share-alt"></i>
            <small>Publish New</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="frontServlet?command=IndexPage">Home</a>
            </li>
            <li class="breadcrumb-item">
                <a href="frontServlet?command=ListProperties">List of Properties</a>
            </li>
            <li class="breadcrumb-item active">Publish a Property</li>
        </ol>

        <hr>

        <form method="post" action="frontServlet">
            <input type="hidden" id="command" name="command" value="PublishProperty">
            <input type="hidden" id="action" name="action" value="publish">
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Property Address</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-4">
                    <label for="street"></label>
                    <input id="street" name="street" type="text" class="form-control" placeholder="Street number and name">
                </div>
                <div class="form-group col-lg-2">
                    <label for="city"></label>
                    <input id="city" name="city" type="text" class="form-control" placeholder="City">
                </div>
                <div class="form-group col-lg-2">
                    <label for="state"></label>
                    <input id="state" name="state" type="text" class="form-control" placeholder="State">
                </div>
                <div class="form-group col-lg-2">
                    <label for="country"></label>
                    <input id="country" name="country" type="text" class="form-control" placeholder="Country">
                </div>
                <div class="form-group col-lg-2">
                    <label for="post-code"></label>
                    <input id="post-code" name="post-code" type="number" class="form-control" placeholder="Post code">
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="h5 font-weight-light text-black-50">Property Type</p>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-6">
                    <select class="custom-select" id="property-type" aria-label="Property Type">
                        <option selected>Choose Property Type</option>
                        <option value="House">House</option>
                        <option value="Apartment & Unit">Apartment & Unit</option>
                        <option value="Town House">Town House</option>
                        <option value="Villa">Villa</option>
                        <option value="Land">Land</option>
                        <option value="Acreage">Acreage</option>
                        <option value="Rural">Rural</option>
                        <option value="Block of Units">Block of Units</option>
                        <option value="Retirement Living">Retirement Living</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="rent-type" name="rent-type" value="rent" onchange="tickCheckBox(this, 'rent-price')">
                        <label class="form-check-label text-black-50 font-weight-light" for="rent-type">For renting</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="sell-type" name="sell-type" value="buy" onchange="tickCheckBox(this, 'sell-price')">
                        <label class="form-check-label text-black-50 font-weight-light" for="sell-type">For selling</label>
                    </div>
                </div>
            </div>
            <div class="row mt-3 mb-3">
                <div class="input-group col-lg-4">
                    <label for="rent-price"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-dollar-sign"></i></span>
                    </div>
                    <input id="rent-price" name="rent-price" type="number" class="form-control" placeholder="Renting price (per week)" disabled>
                    <div class="input-group-append">
                        <span class="input-group-text">PW</span>
                    </div>
                </div>
                <div class="input-group col-lg-4">
                    <label for="sell-price"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-dollar-sign"></i></span>
                    </div>
                    <input id="sell-price" name="sell-price" type="number" class="form-control" placeholder="Selling price" disabled>
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
                    <input id="bed-num" name="bed-num" type="number" class="form-control" placeholder="Number of bedrooms">
                </div>
                <div class="input-group col-lg-3">
                    <label for="bath-num"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-bath"></i></span>
                    </div>
                    <input id="bath-num" name="bath-num" type="number" class="form-control" placeholder="Number of bathrooms">
                </div>
                <div class="input-group col-lg-3">
                    <label for="car-park-num"></label>
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-car-side"></i></span>
                    </div>
                    <input id="car-park-num" name="car-park-num" type="number" class="form-control" placeholder="Number of car parks">
                </div>
            </div>

            <div class="row mb-3">
                <div class="form-group col-lg-4">
                    <label for="inspection-date"></label>
                    <p class="h5 font-weight-light text-black-50">Inspection date</p>
                    <input id="inspection-date" name="inspection-date" type="date" class="form-control" placeholder="Inspection date">
                </div>
                <div class="form-group col-lg-4">
                    <label for="available-date"></label>
                    <p class="h5 font-weight-light text-black-50">Available date</p>
                    <input id="available-date" name="available-date" type="date" class="form-control" placeholder="Available date">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-lg-10">
                    <p class="h5 font-weight-light text-black-50">Additional Description</p>
                    <textarea id="description" name="description" type="text" class="form-control" placeholder="Give some more information."></textarea>
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
                    <button class="btn btn-primary" type="submit">Publish this property</button>
                </div>
            </div>
        </form>
    </div>

    <tags:footer-copyright/>
    <script>
        function tickCheckBox(checkbox, id) {
            let x = document.getElementById(id);
            x.disabled = !checkbox.checked;
        }
    </script>
</body>
</html>
