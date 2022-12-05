package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PelangganDAOImpl;
import model.Pelanggan;

/**
 * Servlet implementation class PelangganServlet
 */
@WebServlet("/PelangganReservasiServlet")
public class PelangganReservasiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PelangganReservasiServlet() {
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
		String nama_pelanggan = request.getParameter("nama");
		String no_telp = request.getParameter("notelp");
		String tanggal = request.getParameter("tanggal");
		
		// add data pelanggan
		PelangganDAOImpl pelangganDAO = new PelangganDAOImpl();;
		int id = pelangganDAO.getLastId() + 1;
		String idPelanggan = "PL" + String.format("%03d", id);
		Pelanggan p = new Pelanggan(idPelanggan, nama_pelanggan, no_telp);
		pelangganDAO.addPelanggan(p);
		
		HttpSession session = request.getSession();

		response.sendRedirect("/RestoranWeb/views/restoran/reservasi/form_pesanan_menu.jsp?id_pelanggan="+idPelanggan);
	}

}
