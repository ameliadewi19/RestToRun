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
import dao.SuplaiDAOImpl;
import model.BahanBaku;
import model.Menyuplai;
import model.Suplier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SuplaiServlet", urlPatterns = {"/SuplaiServlet"})
public class SuplaiServlet extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuplaiServlet() {
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
		String idbahan = request.getParameter("bahanbaku_id_bahan");
		String idsuplier = request.getParameter("suplier_id_suplier");
		
		System.out.println("idbahan: " + idbahan);
		System.out.println("idsuplier: " + idsuplier);
		
		BahanBaku bahan = new BahanBaku();
		bahan.setId_bahan(idbahan);
		Suplier suplier = new Suplier();
		suplier.setId_suplier(idsuplier);
		
		// add data menyuplai
		SuplaiDAOImpl suplaiDAO = new SuplaiDAOImpl();
		
		Menyuplai m = new Menyuplai(bahan, suplier);
		suplaiDAO.addSuplai(m);		
		if (command.equals("konfirmasi")) {
			HttpSession session = request.getSession();
	
			response.sendRedirect("/RestoranWeb/views/restoran/menyuplai/suplai.jsp");
		}
	}
}