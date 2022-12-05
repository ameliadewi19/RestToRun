package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PesananDAOImpl;
import dao.ReservasiDAOImpl;
import model.Pesanan;
import model.Reservasi;

/**
 * Servlet implementation class ReservasiServlet
 */

public class ReservasiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservasiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command = request.getParameter("command");
		String id_pelanggan = request.getParameter("id_pelanggan");
		String tanggal = request.getParameter("tanggal");
		
		System.out.println(command);
		
		if (command.equals("konfirmasi")) {
			// add data pesanan
			PesananDAOImpl pesananDAO = new PesananDAOImpl();
			java.sql.Timestamp tgl = new java.sql.Timestamp(System.currentTimeMillis());
			int no_antri = pesananDAO.getNoAntri();
			int id = pesananDAO.getLastId() + 1;
			String idPesanan = "PS" + String.format("%03d", id);
			Pesanan ps = new Pesanan(idPesanan, "Belum Diverifikasi", tgl, id_pelanggan, no_antri);
			
			pesananDAO.addPesanan(ps);
			
			// add reservasi 
			ReservasiDAOImpl reservasiDAO = new ReservasiDAOImpl();
			int idrs = reservasiDAO.getLastId() + 1;
			String idReservasi = "RS" + String.format("%03d", idrs);
			System.out.println("idreservasi" + idReservasi);
			Reservasi r = new Reservasi(idReservasi, tanggal, idPesanan);
			
			reservasiDAO.addReservasi(r);
			
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/restoran/pembayaran/form_pembayaran.jsp?id_pesanan="+idPesanan);
		} else if (command.equals("batal")){
			
		}
	}

}
