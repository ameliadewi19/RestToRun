<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<!-- header -->
<jsp:include page="../headerDua.jsp"/>
<meta charset="ISO-8859-1">
<body>
  <div class="container-scroller">
  	<!-- sidebar -->
	<jsp:include page="../sidebarDua.jsp"/>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Tabel Pesanan</h4>
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                      <tr>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th><a href="form_pesanan.jsp"><button type="button" class="btn btn-primary"><i class="fa-solid fa-plus"></i></button></a></th>
                        </tr>
                        <tr>
                          <th>Nama</th>
                          <th>Id Pesanan</th>
                          <th>Tanggal</th>
                          <th>Koki</th>
                          <th>Pelayan</th>
                          <th>Status</th>
                          <th>Proses</th>
                          <th>Action</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Jacob</td>
                          <td>53275531</td>
                          <td>12 May 2017</td>
                          <td>Mey</td>
                          <td>Suci</td>
                          <td><label class="badge badge-danger">Pending</label></td>
                          <td><button type="button" class="btn btn-info">Proses</button></td>
                          <td><button type="button" class="btn btn-warning">Edit</button></td>
                          <td><button type="button" class="btn btn-danger">Hapus</button></td>
                        </tr>
                        <tr>
                          <td>Messsy</td>
                          <td>53275532</td>
                          <td>15 May 2017</td>
                          <td>Mey</td>
                          <td>Suci</td>
                          <td><label class="badge badge-warning">In progress</label></td>
                          <td><button type="button" class="btn btn-info">Proses</button></td>
                          <td><button type="button" class="btn btn-warning">Edit</button></td>
                          <td><button type="button" class="btn btn-danger">Hapus</button></td>
                        </tr>
                        <tr>
                          <td>John</td>
                          <td>53275533</td>
                          <td>14 May 2017</td>
                          <td>Mey</td>
                          <td>Suci</td>
                          <td><label class="badge badge-info">Fixed</label></td>
                          <td><button type="button" class="btn btn-info">Proses</button></td>
                          <td><button type="button" class="btn btn-warning">Edit</button></td>
                          <td><button type="button" class="btn btn-danger">Hapus</button></td>
                        </tr>
                        <tr>
                          <td>Peter</td>
                          <td>53275534</td>
                          <td>16 May 2017</td>
                          <td>Mey</td>
                          <td>Suci</td>
                          <td><label class="badge badge-success">Completed</label></td>
                          <td><button type="button" class="btn btn-info">Proses</button></td>
                          <td><button type="button" class="btn btn-warning">Edit</button></td>
                          <td><button type="button" class="btn btn-danger">Hapus</button></td>
                        </tr>
                        <tr>
                          <td>Dave</td>
                          <td>53275535</td>
                          <td>20 May 2017</td>
                          <td>Mey</td>
                          <td>Suci</td>
                          <td><label class="badge badge-warning">In progress</label></td>
                          <td><button type="button" class="btn btn-info">Proses</button></td>
                          <td><button type="button" class="btn btn-warning">Edit</button></td>
                          <td><button type="button" class="btn btn-danger">Hapus</button></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>  
        <!-- content-wrapper ends -->
        <!-- footer -->
		<jsp:include page="../footer.jsp"/>
        
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../../../assets/restoran/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="../../../assets/restoran/off-canvas.js"></script>
  <script src="../../../assets/restoran/hoverable-collapse.js"></script>
  <script src="../../../assets/restoran/template.js"></script>
  <script src="../../../assets/restoran/settings.js"></script>
  <script src="../../../assets/restoran/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
    