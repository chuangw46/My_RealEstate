<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Real Estate</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/modern-business.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
      <!-- Navigation -->
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
          <div class="container">
              <a class="navbar-brand" href="index.jsp">Real Estate</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                  <ul class="navbar-nav ml-auto">
                      <li class="nav-item">
                          <a class="nav-link" href="about.html">About</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="services.html">Services</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="contact.html">Contact</a>
                      </li>
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Portfolio
                          </a>
                          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                              <a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
                              <a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
                              <a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>
                              <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
                              <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
                          </div>
                      </li>
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Blog
                          </a>
                          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                              <a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
                              <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
                              <a class="dropdown-item" href="blog-post.html">Blog Post</a>
                          </div>
                      </li>
                  </ul>
              </div>
          </div>
      </nav>

      <header>
          <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                  <div class="carousel-item active">
                      <img class="d-block w-100" src="http://placehold.it/1900x1080" alt="First slide">
                  </div>
                  <div class="carousel-item">
                      <img class="d-block w-100" src="http://placehold.it/1900x1080" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                      <img class="d-block w-100" src="http://placehold.it/1900x1080" alt="Third slide">
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
      </header>

      <!-- Footer -->
      <footer class="py-5 bg-dark">
          <div class="container">
              <p class="m-0 text-center text-white">Copyright &copy; Junhan Yang & Chuang Wang 2019</p>
          </div>
          <!-- /.container -->
      </footer>
    </body>
</html>
