package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PenggunaDAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PenggunaDAOImpl penggunaDAO = new PenggunaDAOImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String jenisUser = penggunaDAO.getJenis(email);
		String namaUser = penggunaDAO.getNamaUser(email);
		
		System.out.println("Hasil Jenis: " + jenisUser);

		String err = "";
		if (email.equals("") || password.equals("")) {
			err += "Data tidak boleh kosong!";
		} else {
			if (penggunaDAO.login(email, password) == false) {
				err += "Username atau password salah!";
			}
		}

		if (err.length() > 0) {
			request.setAttribute("err", err);
		}

		String url = "/login.jsp";
		try {
			if (err.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("jenisUser", jenisUser);
				session.setAttribute("namaUser", namaUser);
				penggunaDAO.login(email, password);
				
				Cookie loginCookie = new Cookie("email", email);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
	            response.addCookie(loginCookie);
	            
	            String jenis = jenisUser.replaceAll("\\s", "");
            	if(jenis.equals("mnjr")) {
            		response.sendRedirect("/RestoranWeb/views/restoran/index.jsp");
	    	    } else if (jenis.equals("plyn")){
	    	    	response.sendRedirect("/RestoranWeb/views/pelayan/index.jsp");
	    	    } else if (jenis.equals("ksr")){
	    	    	response.sendRedirect("/RestoranWeb/views/kasir/index.jsp");
	    	    } else if (jenis.equals("koki")){
	    	    	response.sendRedirect("/RestoranWeb/views/koki/index.jsp");
	    	    } else if (jenis.equals("stfgdg")){
	    	    	response.sendRedirect("/RestoranWeb/views/staf_gudang/index.jsp");
	    	    }
	            
//				url = "/Index";
			} else {
				url = "/login.jsp";
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login.jsp");
		}
	}
}

