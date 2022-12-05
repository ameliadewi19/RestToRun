package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InvoiceDAOImpl;
import dao.PesananDAOImpl;
import model.Pesanan;

/**
 * Servlet implementation class ProsesPembayaranServlet
 */

public class ProsesPembayaranServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProsesPembayaranServlet() {
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
		String idin = request.getParameter("id_pembayaran");
		
		System.out.println(command);
		
		if (command.equals("konfirmasi_pembayaran")) {
			// add data pesanan
			InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();
			invoiceDAO.updateStatus(idin);
			
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/restoran/pembayaran/pembayaran.jsp");
			
		} else if(command.equals("kasir_konfirmasi_pembayaran")) {
			// add data pesanan
			InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();
			invoiceDAO.updateStatus(idin);
			
			HttpSession session = request.getSession();

			response.sendRedirect("/RestoranWeb/views/kasir/pembayaran/pembayaran.jsp");
		}
	}

}
