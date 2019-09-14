<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
    <title>My Real Estate</title>
    <tags:head/>
  </head>
  <body>

    <% if (request.getSession().getAttribute("currentUser") != null) { %>
        <tags:navbar-log-in/>
    <% } else { %>
        <tags:navbar-log-out/>
    <% } %>

    <div class="container">
        <tags:flash-message/>
        <div class="row">
          <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                  <div class="carousel-item active">
                      <img class="img-fluid d-block" src="./images/andre-francois-mckenzie-rz2YF0vBsvA-unsplash.jpg" alt="First slide">
                  </div>
                  <div class="carousel-item">
                      <img class="img-fluid d-block" src="./images/elsa-noblet-5KD5PmZEfcg-unsplash.jpg" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                      <img class="img-fluid d-block" src="./images/andrew-barrowman--kh2s5BdwxI-unsplash.jpg" alt="Third slide">
                  </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
              </a>
          </div>
      </div>

      <h1 class="my-4">Welcome to My Real Estate</h1>

      <hr>

      <div class="row justify-content-center">
          <div class="col-lg-12 mx-auto bg-white p-3 rounded">
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                  <li class="nav-item">
                      <a class="nav-link active" id="buy-tab" data-toggle="tab" href="#buy" role="tab" aria-controls="home" aria-selected="true">Buy</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="rent-tab" data-toggle="tab" href="#rent" role="tab" aria-controls="profile" aria-selected="false">Rent</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="find-agents-tab" data-toggle="tab" href="#find-agents" role="tab" aria-controls="contact" aria-selected="false">Find Agents</a>
                  </li>
              </ul>
              <div class="tab-content" id="myTabContent">
                  <div class="tab-pane fade show active" id="buy" role="tabpanel" aria-labelledby="rent-tab">
                      <form class="p-5">
                          <div class="row">
                              <div class="input-group col-md-12">
                                  <select class="custom-select" id="buy-property-type" aria-label="Property Type">
                                      <option value="0" selected>All Property Types</option>
                                      <option value="1">House</option>
                                      <option value="2">Apartment & Unit</option>
                                      <option value="3">Town House</option>
                                      <option value="4">Villa</option>
                                      <option value="5">Land</option>
                                      <option value="6">Acreage</option>
                                      <option value="7">Rural</option>
                                      <option value="8">Block of Units</option>
                                      <option value="9">Retirement Living</option>
                                  </select>
                                  <select class="custom-select" id="buy-beds-max" aria-label="Beds Max">
                                      <option selected>Beds (Max)</option>
                                      <option value="1">Any</option>
                                      <option value="2">Studio</option>
                                      <option value="3">1 Bed</option>
                                      <option value="4">2 Beds</option>
                                      <option value="5">3 Beds</option>
                                      <option value="6">4 Beds</option>
                                      <option value="7">5 Beds</option>
                                  </select>
                                  <select class="custom-select" id="buy-beds-min" aria-label="Beds Min">
                                      <option selected>Beds (Min)</option>
                                      <option value="1">Any</option>
                                      <option value="2">Studio</option>
                                      <option value="3">1 Bed</option>
                                      <option value="4">2 Beds</option>
                                      <option value="5">3 Beds</option>
                                      <option value="6">4 Beds</option>
                                      <option value="7">5 Beds</option>
                                  </select>
                                  <select class="custom-select" id="buy-price-max" aria-label="Price Max">
                                      <option selected>Price (Max)</option>
                                      <option value="1">Any</option>
                                      <option value="2">$50,000</option>
                                      <option value="3">$75,000</option>
                                      <option value="4">$100,000</option>
                                      <option value="5">$125,000</option>
                                      <option value="6">$150,000</option>
                                      <option value="7">$175,000</option>
                                      <option value="8">$200,000</option>
                                  </select>
                                  <select class="custom-select" id="buy-price-min" aria-label="Price Min">
                                      <option selected>Price (Min)</option>
                                      <option value="1">Any</option>
                                      <option value="2">$50,000</option>
                                      <option value="3">$75,000</option>
                                      <option value="4">$100,000</option>
                                      <option value="5">$125,000</option>
                                      <option value="6">$150,000</option>
                                      <option value="7">$175,000</option>
                                      <option value="8">$200,000</option>
                                  </select>
                              </div>
                          </div>
                          <div class="row mt-5">
                              <div class="input-group form-group col-md-10">
                                  <label for="buy-search"></label>
                                  <input id="buy-search" type="text" placeholder="Search By Postcode"
                                         class="form-control form-control-underlined">
                              </div>
                              <div class="form-group col-md-2">
                                  <button type="submit" class="btn btn-primary rounded-pill btn-block shadow-sm" disabled>Search</button>
                              </div>
                          </div>
                      </form>
                  </div>
                  <div class="tab-pane fade" id="rent" role="tabpanel" aria-labelledby="sell-tab">
                      <form class="p-5">
                          <div class="row">
                              <div class="input-group col-md-12">
                                  <select class="custom-select" id="rent-property-type" aria-label="Property Type">
                                      <option value="0" selected>All Property Types</option>
                                      <option value="1">House</option>
                                      <option value="2">Apartment & Unit</option>
                                      <option value="3">Town House</option>
                                      <option value="4">Villa</option>
                                      <option value="5">Land</option>
                                      <option value="6">Acreage</option>
                                      <option value="7">Rural</option>
                                      <option value="8">Block of Units</option>
                                      <option value="9">Retirement Living</option>
                                  </select>
                                  <select class="custom-select" id="rent-beds-max" aria-label="Beds Max">
                                      <option selected>Beds (Max)</option>
                                      <option value="1">Any</option>
                                      <option value="2">Studio</option>
                                      <option value="3">1 Bed</option>
                                      <option value="4">2 Beds</option>
                                      <option value="5">3 Beds</option>
                                      <option value="6">4 Beds</option>
                                      <option value="7">5 Beds</option>
                                  </select>
                                  <select class="custom-select" id="rent-beds-min" aria-label="Beds Min">
                                      <option selected>Beds (Min)</option>
                                      <option value="1">Any</option>
                                      <option value="2">Studio</option>
                                      <option value="3">1 Bed</option>
                                      <option value="4">2 Beds</option>
                                      <option value="5">3 Beds</option>
                                      <option value="6">4 Beds</option>
                                      <option value="7">5 Beds</option>
                                  </select>
                                  <select class="custom-select" id="rent-price-max" aria-label="Price PW Max">
                                      <option selected>Price per week (Max)</option>
                                      <option value="1">Any</option>
                                      <option value="2">$50 pw</option>
                                      <option value="3">$75 pw</option>
                                      <option value="4">$100 pw</option>
                                      <option value="5">$125 pw</option>
                                      <option value="6">$150 pw</option>
                                      <option value="7">$175 pw</option>
                                      <option value="8">$200 pw</option>
                                  </select>
                                  <select class="custom-select" id="price-min" aria-label="Price PW Min">
                                      <option selected>Price per week (Min)</option>
                                      <option value="1">Any</option>
                                      <option value="2">$50 pw</option>
                                      <option value="3">$75 pw</option>
                                      <option value="4">$100 pw</option>
                                      <option value="5">$125 pw</option>
                                      <option value="6">$150 pw</option>
                                      <option value="7">$175 pw</option>
                                      <option value="8">$200 pw</option>
                                  </select>
                              </div>
                          </div>
                          <div class="row mt-5">
                              <div class="input-group form-group col-md-10">
                                  <label for="rent-search"></label>
                                  <input id="rent-search" type="text" placeholder="Search By Postcode"
                                         class="form-control form-control-underlined">
                              </div>
                              <div class="form-group col-md-2">
                                  <button type="submit" class="btn btn-primary rounded-pill btn-block shadow-sm" disabled>Search</button>
                              </div>
                          </div>
                      </form>
                  </div>
                  <div class="tab-pane fade p-5" id="find-agents" role="tabpanel" aria-labelledby="find-agents-tab">
                      <form>
                          <div class="row">
                              <div class="input-group form-group col-md-10">
                                  <label for="agent-search"></label>
                                  <input id="agent-search" type="text" placeholder="Search Agent By Name"
                                         class="form-control form-control-underlined">
                              </div>
                              <div class="form-group col-md-2">
                                  <button type="submit" class="btn btn-primary rounded-pill btn-block shadow-sm" disabled>Search</button>
                              </div>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </div>

      <hr>

      <div class="row">
          <div class="col-lg-4 mb-6">
              <div class="card h-100 text-center">
                  <h4 class="card-header">
                      Track my enquiry status
                      <i class="far fa-question-circle"></i>
                  </h4>
                  <div class="card-body">
                      <p class="card-text">
                          As a buyer or tenant, you can create new enquires to a specific agent with regards to the
                          property that I am interested. As an agent, you can view a list of the enquiries sent by
                          a buyer or tenant and respond to any of them.
                      </p>
                  </div>
                  <div class="card-footer">
                      <a href="frontServlet?command=ViewEnquiry" class="btn btn-info">Manage my enquires</a>
                  </div>
              </div>
          </div>
          <div class="col-lg-4 mb-6">
              <div class="card h-100 text-center">
                  <h4 class="card-header">
                      Review my favourite list
                      <i class="fas fa-shopping-cart"></i>
                  </h4>
                  <div class="card-body">
                      <p class="card-text">
                          As a buyer or tenant, you can mark a property that you are interested to follow up. This
                          property then will be added into your personal favourite list, which can be reviewed and
                          modified by you anytime.
                      </p>
                  </div>
                  <div class="card-footer">
                      <a href="#" class="btn btn-info disabled">Check out favourite list</a>
                  </div>
              </div>
          </div>
          <div class="col-lg-4 mb-6">
              <div class="card h-100 text-center">
                  <h4 class="card-header">
                      Publish properties
                      <i class="fas fa-home"></i>
                  </h4>
                  <div class="card-body">
                      <p class="card-text">
                          As an agent, you can publish a new property along with the general description and a series
                          of photos. After publishing the property, buyers or tenants are able to find it immediately
                          on this platform.
                      </p>
                  </div>
                  <div class="card-footer">
                      <a href="frontServlet?command=RedirectPublish" class="btn btn-info">Publish a property</a>
                  </div>
              </div>
          </div>
      </div>

      <br>
      <hr>

      <!-- Call to Action Section -->
      <div class="row mb-4">
          <div class="col-md-8 text-center">
              <p class="h5 font-weight-light text-black-50">
                  Follow our work on
                  <a href="https://github.com/chuangw46/SWEN90007_Project">
                      <i class="fab fa-github fa-2x"></i>
                  </a>
              </p>
          </div>
      </div>
    </div>

    <tags:footer-copyright/>
  </body>
</html>
