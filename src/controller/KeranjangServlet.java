package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KeranjangDAOImpl;
import model.Keranjang;
import model.Menu;
import model.Pelanggan;

public class KeranjangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Keranjang> keranjang = new ArrayList<Keranjang>();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KeranjangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String id_pelanggan = request.getParameter("id_pelanggan");
		String id_menu = request.getParameter("id_menu");
		String jumlah = request.getParameter("jumlah");
		int jumlahPesanan = Integer.parseInt(jumlah);
		
		// add to keranjang
		
		Menu menu = new Menu();
		menu.setId_menu(id_menu);
		Pelanggan pelanggan = new Pelanggan();
		pelanggan.setId_pelanggan(id_pelanggan);
		Keranjang k = new Keranjang(menu, jumlahPesanan, pelanggan);
		
		KeranjangDAOImpl keranjangDAO = new KeranjangDAOImpl();
		keranjangDAO.addKeranjang(k);
		
		if (command.equals("konfirmasi")) {
		
			HttpSession session = request.getSession();
			
			
			System.out.println(id_pelanggan);
	
			response.sendRedirect("/RestoranWeb/views/restoran/pesanan/form_pesanan_menu.jsp?id_pelanggan="+id_pelanggan);
		} else if (command.equals("pelanggan_konfirmasi")) {
			HttpSession session = request.getSession();
			
			
			System.out.println(id_pelanggan);
	
			response.sendRedirect("/RestoranWeb/views/pelanggan/cart.jsp?id_pelanggan="+id_pelanggan);
		} else if (command.equals("kasir_konfirmasi")) {
			HttpSession session = request.getSession();
			
			
			System.out.println(id_pelanggan);
	
			response.sendRedirect("/RestoranWeb/views/kasir/pesanan/form_pesanan_menu.jsp?id_pelanggan="+id_pelanggan);
		}
	}
}
