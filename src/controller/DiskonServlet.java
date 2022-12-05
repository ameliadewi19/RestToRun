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
import dao.DiskonDAOImpl;
import dao.MenuDAOImpl;
import model.BahanBaku;
import model.Diskon;
import model.Menu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DiskonServlet", urlPatterns = {"/DiskonServlet"})
public class DiskonServlet extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiskonServlet() {
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
		String idmenu = request.getParameter("idmenu");
		String tanggal_mulai = request.getParameter("tanggalmulai");
		String tanggal_akhir = request.getParameter("tanggalakhir");
		String potongan = request.getParameter("potongan");
		
		System.out.println(tanggal_mulai);
		System.out.println(tanggal_akhir);
		
		Date tglmulai = null;
		try {
			tglmulai = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_mulai);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Timestamp tanggalmulai = new java.sql.Timestamp(tglmulai.getTime());
		
		Date tglakhir = null;
		try {
			tglakhir = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_akhir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Timestamp tanggalakhir = new java.sql.Timestamp(tglakhir.getTime());
		
		int potonganDiskon = Integer.parseInt(potongan);
		
		Menu m = new Menu();
		m.setId_menu(idmenu);
		
		// add data diskon
		DiskonDAOImpl diskonDAO = new DiskonDAOImpl();
		Diskon d = new Diskon(potonganDiskon, tanggalmulai, tanggalakhir, m);
		diskonDAO.addDiskon(d);
		
		HttpSession session = request.getSession();

		response.sendRedirect("/RestoranWeb/views/restoran/diskon/diskon.jsp");
	}
}