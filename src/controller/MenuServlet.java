package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MenuDAOImpl;
import dao.PelangganDAOImpl;
import model.JenisMenu;
import model.Menu;
import model.Pelanggan;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
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
		String nama_menu = request.getParameter("nama_menu");
		String harga_menu = request.getParameter("harga_menu");
		String estimasi = request.getParameter("estimasi");
		String stok = request.getParameter("stok");
		String jenis = request.getParameter("jenis_menu");
		
		System.out.println("jenis menu: " + jenis);
		
		int harga = Integer.parseInt(harga_menu);
		int est = Integer.parseInt(estimasi);
		int stokmenu = Integer.parseInt(stok);
		
		JenisMenu jenisMenu = new JenisMenu(jenis, "");
		
		// add data pelanggan
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		int id = menuDAO.getLastId() + 1;
		String idPelanggan = "MN" + String.format("%03d", id);
		Menu m = new Menu("", nama_menu, harga, est, stokmenu, jenisMenu);
		menuDAO.addMenu(m);
	
		HttpSession session = request.getSession();

		response.sendRedirect("/RestoranWeb/views/restoran/menu/menu.jsp");
	}

}
