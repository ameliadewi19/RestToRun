package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InvoiceDAOImpl;
import dao.PenggunaDAOImpl;
import dao.PesananDAOImpl;

/**
 * Servlet implementation class ProsesPesananServlet
 */

public class ProsesPesananServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProsesPesananServlet() {
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
		String idps = request.getParameter("id_pesanan");
		String email = request.getParameter("email");
		
		System.out.println(command);
		
		if (command.equals("konfirmasi_pesanan")) {
			// add data pesanan
			PesananDAOImpl pesananDAO = new PesananDAOImpl();
			pesananDAO.verifikasiPesanan(idps);
			
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/kasir/pesanan/pesanan.jsp");
		} else if (command.equals("koki_mengelola")){
			// get id pengguna
			PenggunaDAOImpl penggunaDAO = new PenggunaDAOImpl();
			String idPengguna = penggunaDAO.getIdPelangganByEmail(email);
			
			// add data koki mengelola
			PesananDAOImpl pesananDAO = new PesananDAOImpl();
			pesananDAO.kokiMengelola(idPengguna, idps);
						
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/koki/pesanan/pesanan.jsp");
		} else if (command.equals("koki_mengelola_selesai")) {
			// add data koki mengelola
			PesananDAOImpl pesananDAO = new PesananDAOImpl();
			pesananDAO.kokiMengelolaSelesai(idps);
									
			HttpSession session = request.getSession();
			
			response.sendRedirect("/RestoranWeb/views/koki/pesanan/pesanan.jsp");
		} else if (command.equals("pelayan_mengantar_selesai")) {
			// get id pengguna
			PenggunaDAOImpl penggunaDAO = new PenggunaDAOImpl();
			String idPengguna = penggunaDAO.getIdPelangganByEmail(email);
						
			// add data koki mengelola
			PesananDAOImpl pesananDAO = new PesananDAOImpl();
			pesananDAO.pelayanMengantarSelesai(idPengguna, idps);
									
			HttpSession session = request.getSession();
			
			response.sendRedirect("/RestoranWeb/views/pelayan/pesanan/pesanan.jsp");
		}
	}

}
