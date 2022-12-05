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
import dao.PemasokDAOImpl;
import model.BahanBaku;
import model.Menu;
import model.Suplier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

@WebServlet(name = "SuplierServlet", urlPatterns = {"/SuplierServlet"})
public class SuplierServlet extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuplierServlet() {
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
		String namasuplier = request.getParameter("namasuplier");
		String alamat = request.getParameter("alamat");
		
		System.out.println(command);
		
		if (command.equals("suplier_add")) {
			// add data pelanggan
			PemasokDAOImpl pemasokDAO = new PemasokDAOImpl();
			Suplier s = new Suplier("", namasuplier, alamat);
			pemasokDAO.addPemasok(s);
		
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/restoran/bahan/bahan.jsp");
		}
	}
}
