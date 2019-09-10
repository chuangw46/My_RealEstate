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
    <script src="https://kit.fontawesome.com/c42c4fb0e2.js"></script>
  </head>
  <body>
      <!-- Navigation -->
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
          <div class="container">
              <a class="navbar-brand" href="index.jsp">
                  <i class="fas fa-sign"></i>
                  My Real Estate
              </a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                  <ul class="navbar-nav ml-auto">
                      <li class="nav-item">
                          <a class="nav-link" href="about.html">About</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="properties.jsp">Properties</a>
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
                      <li class="nav-item">
                          <a class="nav-link" href="login.jsp">
                              Log In <i class="fas fa-sign-in-alt"></i>
                          </a>
                      </li>
                  </ul>
              </div>
          </div>
      </nav>

      <div class="container">
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

          <div class="row">
              <div class="col-lg-6 mb-6">
                  <div class="card h-100">
                      <h4 class="card-header">
                          <i class="fas fa-dove"></i>
                          I am a tenant or buyer.
                      </h4>
                      <div class="card-body">
                          <p class="card-text">
                              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.
                          </p>
                      </div>
                      <div class="card-footer">
                          <a href="#" class="btn btn-info">Learn More</a>
                      </div>
                  </div>
              </div>
              <div class="col-lg-6 mb-6">
                  <div class="card h-100">
                      <h4 class="card-header">
                          <i class="fas fa-broadcast-tower"></i>
                          I am an agent.
                      </h4>
                      <div class="card-body">
                          <p class="card-text">
                              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.
                          </p>
                      </div>
                      <div class="card-footer">
                          <a href="#" class="btn btn-info">Learn More</a>
                      </div>
                  </div>
              </div>
          </div>

          <hr>

          <!-- Call to Action Section -->
          <div class="row mb-4">
              <div class="col-md-8">
                  <p>
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.
                  </p>
              </div>
              <div class="col-md-4">
                  <a class="btn btn-lg btn-secondary" href="#">JOIN US</a>
              </div>
          </div>
      </div>

      <!-- Footer -->
      <footer class="py-5 bg-dark">
          <div class="container">
              <p class="m-0 text-center text-white">Copyright &copy; Junhan Yang & Chuang Wang 2019</p>
          </div>
          <!-- /.container -->
      </footer>
    </body>
</html>
