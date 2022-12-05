package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DetailPesananDAOImpl;
import dao.InvoiceDAOImpl;
import dao.PelangganDAOImpl;
import dao.PenggunaDAOImpl;
import dao.PesananDAOImpl;
import model.Invoice;
import model.Pelanggan;
import model.Pengguna;

/**
 * Servlet implementation class PembayaranServlet
 */
@WebServlet("/PembayaranServlet")
public class PembayaranServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PembayaranServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		String metode = request.getParameter("metode");
		String jumlah = request.getParameter("jumlah");
		String email = request.getParameter("email");
		String idpes = request.getParameter("idpesanan");
		int jumlahHarga = Integer.parseInt(jumlah);
		
		// get id pengguna
		PenggunaDAOImpl penggunaDAO = new PenggunaDAOImpl();
		System.out.println("email: " + email);
		System.out.println("jumlah: " + jumlah);
		String idPengguna = penggunaDAO.getIdPelangganByEmail(email);
		
		// add detail pesanan
		DetailPesananDAOImpl detailDAO = new DetailPesananDAOImpl();
		PesananDAOImpl pes = new PesananDAOImpl();
		String idpl = pes.getIDPelIDPes(idpes);
		System.out.println("idpl: " + idpl);
		System.out.println("idpl: " + idpes);
		detailDAO.addDetailPesananAll(idpl, idpes);
		
		// add data pembayaran
		InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();;
		int id = invoiceDAO.getLastId() + 1;
		String idInvoice = "IN" + String.format("%03d", id);
		Invoice i = new Invoice(idInvoice, jumlahHarga, idPengguna, "Belum Dibayar", idpes, 0, 0, 0, 0, metode);
		
		invoiceDAO.addInvoice(i);
		
		
		if (command.equals("konfirmasi")) {
			HttpSession session = request.getSession();
	
			response.sendRedirect("/RestoranWeb/views/restoran/pembayaran/pembayaran.jsp");
		} else if (command.equals("kasir_konfirmasi")) {
			HttpSession session = request.getSession();
			
			response.sendRedirect("/RestoranWeb/views/kasir/pembayaran/pembayaran.jsp");
		}
	}

}