<%@page import="dao.MenuDAOImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Resto</title>
    <meta name="description" content="Resto">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

     <!-- Favicons -->
     <link href="../../assets/pelanggan/img/favicon.png" rel="icon">
     <link href="../../assets/pelanggan/img/apple-touch-icon.png" rel="apple-touch-icon">
    
     <!-- Google Fonts -->
     <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    
     <!-- Vendor CSS Files -->
     <link href="../../assets/pelanggan/vendor/animate.css/animate.min.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/aos/aos.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
     <link href="../../assets/pelanggan/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
     
     <!-- Template Main CSS File -->
     <link href="../../assets/pelanggan/css/style.min.css" rel="stylesheet">
     <link href="../../assets/pelanggan/css/style.css" rel="stylesheet">
     
     <!-- CSS -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.css">

</head>
<body data-spy="scroll" data-target="#navbar" class="static-layout">
    <div id="side-nav" class="sidenav">
    <a href="javascript:void(0)" id="side-nav-close">&times;</a>
    
    <div class="sidenav-content">
        <p>
            Kuncen WB1, Wirobrajan 10010, DIY
        </p>
        <p>
            <span class="fs-16 primary-color">(+68) 120034509</span>
        </p>
        <p>info@yourdomain.com</p>
    </div>
</div>  
<div id="side-search" class="sidenav">
    <a href="javascript:void(0)" id="side-search-close">&times;</a>
    <div class="sidenav-content">
        <form action="">

            <div class="input-group md-form form-sm form-2 pl-0">
              <input class="form-control my-0 py-1 red-border" type="text" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="input-group-text red lighten-3" id="basic-text1">
                    <i class="fas fa-search text-grey" aria-hidden="true"></i>
                </button>
              </div>
            </div>

        </form>
    </div>
    
    
</div>  
<div id="canvas-overlay"></div>
    <div class="boxed-page">
        <nav id="navbar-header" class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand navbar-brand-center d-flex align-items-center p-0 only-mobile" href="/">
            <img src="../../assets/restoran/images/logo2.png" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="lnr lnr-menu"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav d-flex justify-content-between">
                <li class="nav-item only-desktop">
                    <a class="nav-link" id="side-nav-open" href="#">
                        <span class="lnr lnr-menu"></span>
                    </a>
                </li>
                <div class="d-flex flex-lg-row flex-column">
                    <li class="nav-item active">
                        <a class="nav-link" href="../../index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="pesanan.jsp">Pesanan</a>
                    </li>
                </div>
            </ul>
            
            <a class="navbar-brand navbar-brand-center d-flex align-items-center only-desktop" href="#">
                <img src="../../assets/restoran/images/logo2.png" alt="">
            </a>
            <ul class="navbar-nav d-flex justify-content-between">
                <div class="d-flex flex-lg-row flex-column">
                    <li class="nav-item active">
                        <a class="nav-link" href="menu.jsp">Menu</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="reservation.jsp">Reservation</a>
                    </li>
                </div>
                <li class="nav-item">
                    <a type="button" class="btn btn-dark" href="../../login.jsp">Log in</a>
                </li>
            </ul>
        </div>
    </div>
</nav>          
<!-- Reservation Section -->
<section id="menu" class="menu section-bg">
    <div class="container">
    	<div class="section-title">
          <h2></h2>
          <p style="text-align: center;">Detail Menu</p>
        </div>
        
        <div class="card">
             <div class="card-body">
                <div class="row">
                   <div class="col-xl-3 ">
                        <!-- Tab panes -->
                         <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="first">
                                <img class="img-fluid" src="../../assets/pelanggan/img/menu/lobster-bisque.jpg" alt="">
                             </div>
                          </div>                                               
                    </div>
                    <%
                        
                        String id_menu = "";
                        if (request.getParameter("id_menu") != null) {
                            id_menu = request.getParameter("id_menu");
                        }
                
                        MenuDAOImpl menuDAO = new MenuDAOImpl();
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumFractionDigits(0);
                    %>
                    
                    
                                    <!--Tab slider End-->
                                    <div class="col-xl-9 col-sm-12">
                                        <div class="product-detail-content">
                                            <!--Product details-->
                                            <div class="new-arrival-content pr">
                                                <h4><%= menuDAO.getMenu(id_menu).getNama_menu() %></h4>
                                                <br/>
                                                <p class="price">Rp. <%= menuDAO.getMenu(id_menu).getHarga() %></p>
                                                <p>Stok: <span class="item"> <%= menuDAO.getMenu(id_menu).getStok() %> <i
                                                            class="fa fa-shopping-basket"></i></span>
                                                </p>
                                                <p>Product code: <span class="item"><%= menuDAO.getMenu(id_menu).getId_menu() %></span> </p>
                                                <!-- <div class="filtaring-area my-3">
                                                    <div class="size-filter">
                                                        <h4 class="m-b-15">Select size</h4>
                                                        <ul>
                                                            <li class="btn btn-primary light sharp">Regular</li>
                                                            <li class="btn btn-primary light sharp">Large</l>
                                                        </ul>
                                                    </div>
                                                </div>
                                                -->
                                                <!--
                                                <div class="col-2 px-0">
                                                    <input type="number" name="num" class="form-control input-btn input-number" value="1">
                                                </div>
                                                -->
                                                 <div class="shopping-cart mt-3">
                                                    <a class="btn btn-primary btn-lg" href="/RestoranWeb/views/pelanggan/menu.jsp"><i
                                                            class="fa fa-shopping-basket mr-2"></i>Kembali</a>
                                                </div> 
                                            </div>
                   </div>
                </div>
             </div>
            </div>
           </div>
        
        <br/>
        <br/>
      </div>
    </section>
<!-- End of Reservation Section -->     
<footer class="mastfoot pb-5 bg-white section-padding pb-0">
    <div class="inner container">
         <div class="row">
            <div class="col-lg-4">
                <div class="footer-widget pr-lg-5 pr-0">
                    <img src="../../assets/restoran/images/logo2.png" class="img-fluid footer-logo mb-3" alt="">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et obcaecati quisquam id sit omnis explicabo voluptate aut placeat, soluta, nisi ea magni facere, itaque incidunt modi? Magni, et voluptatum dolorem.</p>
                    <nav class="nav nav-mastfoot justify-content-start">
                        <a class="nav-link" href="#">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="nav-link" href="#">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="nav-link" href="#">
                            <i class="fab fa-instagram"></i>
                        </a>
                    </nav>
                </div>
                
            </div>
            <div class="col-lg-4">
                <div class="footer-widget px-lg-5 px-0">
                    <h4>Open Hours</h4>
                    <ul class="list-unstyled open-hours">
                        <li class="d-flex justify-content-between"><span>Monday</span><span>9:00 - 24:00</span></li>
                        <li class="d-flex justify-content-between"><span>Tuesday</span><span>9:00 - 24:00</span></li>
                        <li class="d-flex justify-content-between"><span>Wednesday</span><span>9:00 - 24:00</span></li>
                        <li class="d-flex justify-content-between"><span>Thursday</span><span>9:00 - 24:00</span></li>
                        <li class="d-flex justify-content-between"><span>Friday</span><span>9:00 - 02:00</span></li>
                        <li class="d-flex justify-content-between"><span>Saturday</span><span>9:00 - 02:00</span></li>
                        <li class="d-flex justify-content-between"><span>Sunday</span><span> Closed</span></li>
                      </ul>
                </div>
                
            </div>

            <div class="col-lg-4">
                <div class="footer-widget pl-lg-5 pl-0">
                    <h4>Newsletter</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                    <form id="newsletter">
                        <div class="form-group">
                            <input type="email" class="form-control" id="emailNewsletter" aria-describedby="emailNewsletter" placeholder="Enter email">
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Submit</button>
                    </form>
                </div>
                
            </div>
            <div class="col-md-12 d-flex align-items-center">
                <p class="mx-auto text-center mb-0">Copyright 2019. All Right Reserved. Design by <a href="https://gettemplates.co" target="_blank">GetTemplates</a></p>
            </div>
            
        </div>
    </div>
</footer>   </div>
</div>
    <!-- Main JS -->
    <script src="../../assets/pelanggan/js/app.min.js "></script>
    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

      <!-- Vendor JS Files -->
      <script src="../../assets/pelanggan/vendor/aos/aos.js"></script>
      <script src="../../assets/pelanggan/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="../../assets/pelanggan/vendor/glightbox/js/glightbox.min.js"></script>
      <script src="../../assets/pelanggan/vendor/isotope-layout/isotope.pkgd.min.js"></script>
      <script src="../../assets/pelanggan/vendor/php-email-form/validate.js"></script>
      <script src="../../assets/pelanggan/vendor/swiper/swiper-bundle.min.js"></script>

      <!-- Template Main JS File -->
      <script src="../../assets/pelanggan/js/main.js"></script>
      <script src="../../assets/pelanggan/js/main.min.js"></script>
</body>
</html>
