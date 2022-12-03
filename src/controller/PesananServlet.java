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

import dao.PelangganDAOImpl;
import dao.PesananDAOImpl;
import model.Pelanggan;
import model.Pesanan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class PesananServlet extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PesananServlet() {
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
		doPost(request, response);
//		response.sendRedirect("views/restoran/pesanan/pesanan.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String id_pelanggan = request.getParameter("id_pelanggan");
		
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
			
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/restoran/pembayaran/form_pembayaran.jsp?id_pesanan="+idPesanan);
		} else if (command.equals("batal")){
			
		}
		
	}
}
