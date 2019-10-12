<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="frontServlet?command=IndexPage">
            <i class="fas fa-sign"></i>
            My Real Estate
        </a>

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="frontServlet?command=IndexPage">
                        Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="frontServlet?command=ViewProfile">
                        <i class="far fa-user-circle"></i>
                        ${currentUser.name}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="frontServlet?command=SignOut">Sign out </a>
                </li>
            </ul>
        </div>
    </div>
</nav>