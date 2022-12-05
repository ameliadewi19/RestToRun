package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BahanDAOImpl;
import dao.MenuDAOImpl;
import model.BahanBaku;
import model.Menu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

@WebServlet(name = "BahanServlet", urlPatterns = {"/Bahan"})
public class BahanServlet extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BahanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.sendRedirect("views/restoran/pesanan/pesanan.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String nama_bahan = request.getParameter("namabahan");
		String stok = request.getParameter("stok");
		
		System.out.println(command);
		
		int stokbahan = Integer.parseInt(stok);
		
		if (command.equals("manajer_add")) {
			// add data pelanggan
			BahanDAOImpl bahanDAO = new BahanDAOImpl();
			BahanBaku b = new BahanBaku("", nama_bahan, stokbahan);
			bahanDAO.addBahanBaku(b);
		
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/restoran/bahan/bahan.jsp");
		}
	}
}
