<%@page import="java.util.ArrayList"%>
<%@page import="model.Menu"%>
<%@page import="model.Keranjang"%>
<%@page import="java.util.List"%>
<%@page import="dao.MenuDAOImpl"%>
<%@page import="dao.KeranjangDAOImpl"%>
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

    <!-- External CSS -->
    <link rel="stylesheet" href="../../assets/pelanggan/vendor/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/pelanggan/vendor/select2/select2.min.css">
    <link rel="stylesheet" href="../../assets/pelanggan/vendor/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.css">

    <!-- Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700|Josefin+Sans:300,400,700">
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="../../assets/pelanggan/css/style.min.css">

    <!-- Modernizr JS for IE8 support of HTML5 elements and media queries -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>

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
<section id="" >
    <br/>
    <br/>
    <div class="container">
    <div class="row">
                    
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header"> Tambah Keranjang </div>
                            <div class="card-body">
                                
                                <form method="post" name="contact-us" action="/RestoranWeb/KeranjangReservasiServlet?command=pelanggan_konfirmasi">
                                    <div class="row">
                                        <div class="col-md-12 form-group">
                                            <input type="text" class="form-control" id="name" name="id_menu" placeholder="ID Menu">
                                        </div>
                                        <div class="col-md-12 form-group">
                                            <input type="number" class="form-control" id="phoneNumber" name="jumlah" placeholder="Jumlah Pesan">
                                        </div>
                                        <%
                                            String id_pelanggan = request.getParameter("id_pelanggan");
                                        %>
                                        <input type="hidden" class="" name="id_pelanggan" value="<%=id_pelanggan%>">
                                        <div class="col-md-12 text-center">
                                            <button class="btn btn-success btn-shadow btn-lg" type="submit" name="submit">Tambah Keranjang</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <%
                        MenuDAOImpl menuDAO = new MenuDAOImpl();
                
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumFractionDigits(0);
                    %>
                    <%
                        KeranjangDAOImpl keranjangDAO = new KeranjangDAOImpl();
                    
                        String id_plgn = request.getParameter("id_pelanggan");
                    %>
                    
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header"> Tabel Keranjang </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th class="center">ID Pelanggan</th>
                                                <th class="center">ID Menu</th>
                                                <th class="center">Jumlah</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%  for (Keranjang k : keranjangDAO.getListPelanggan(id_plgn)) {
                                            %>
                                            <pg:item>
                                            <tr>
                                              <td><%= k.getPelanggan().getId_pelanggan() %></td>
                                              <td><%= k.getMenu().getId_menu() %></td>
                                              <td><%= k.getJumlah() %></td>
                                            </tr>
                                            </pg:item>
                                            <%
                                                }
                                                    
                                            %>
                                        </tbody>
                                    </table>
                                    <div class="col-md-12 text-center">
                                            <a class="" href="/RestoranWeb/PesananServlet?command=pelanggan_konfirmasi&id_pelanggan=<%= id_plgn %>"><button class="btn btn-success btn-shadow btn-lg" type="submit" name="submit">Tambah Pesanan</button></a>
                                        </div>
                                </div>  
                            </div>
                        </div>
                    </div>
                  </div>
                    <br/>
                    <br/>
                    <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header"> Data Menu </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>	
                                                <th class="center">ID Menu</th>
                                                <th class="center">ID Jenis</th>
                                                <th class="center">Nama Menu</th>
                                                <th class="center">Harga</th>
                                                <th class="center">Estimasi Waktu</th>
                                                <th class="center">Stok</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%  for (Menu m : menuDAO.getList()) {
                                            %>    
                                            <pg:item>
                                            <tr>
                                              <td><%= m.getId_menu() %></td>
                                              <td><%= m.getJenis_menu().getId_jenis() %></td>
                                              <td><%= m.getNama_menu() %></td>
                                              <td><%= m.getHarga() %></td>
                                              <td><%= m.getEstimasi_waktu() %></td>
                                              <td><%= m.getStok() %></td>
                                            </tr>
                                            </pg:item>
                                            <%
                                                }
                                                    
                                            %>
                                        </tbody>
                                    </table>
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
    <!-- External JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="../../assets/pelanggan/vendor/bootstrap/popper.min.js"></script>
    <script src="../../assets/pelanggan/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="../../assets/pelanggan/vendor/select2/select2.min.js "></script>
    <script src="../../assets/pelanggan/vendor/owlcarousel/owl.carousel.min.js"></script>
    <script src="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.js"></script>
    <script src="../../assets/pelanggan/vendor/stellar/jquery.stellar.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Main JS -->
    <script src="../../assets/pelanggan/js/app.min.js "></script>
</body>
</html>
