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
		HttpSession session = request.getSession();
		
		
		System.out.println(id_pelanggan);

		response.sendRedirect("/RestoranWeb/views/restoran/pesanan/form_pesanan_menu.jsp?id_pelanggan="+id_pelanggan);
		
//		if (command.equals("addCart")) {
//			Menu m = new Menu(id_menu, "", 0, 0, 0, "");
//			addToCart(m);
//			
//			// setelah menambahkan toko, kami akan beralih ke halaman toko
//			// dapat membuat sesi untuk menyimpan nilai
//			HttpSession session = request.getSession();
//
//			// dapatkah kita menguji apakah waktunya dapat ditambahkan?
//			System.out.println(keranjang.size());
//			session.setAttribute("keranjang", keranjang);
//			response.sendRedirect("/views/restoran/index.jsp");
//		} else{
//			if(command.equals("deleteCart")){
//				Menu m = new Menu(id_menu, "", 0, 0, 0, "");
//				deleteFromCart(m);
//				HttpSession session = request.getSession();
//
//				// dapatkah kita menguji apakah waktunya dapat ditambahkan?
//				System.out.println(keranjang.size());
//				session.setAttribute("keranjang", keranjang);
//				response.sendRedirect("/views/restoran/index.jsp");
//			} else{
//				if(command.equals("removeCart")){
//					Menu m = new Menu(id_menu, "", 0, 0, 0, "");
//					removeFromCart(m);
//					HttpSession session = request.getSession();
//
//					//simpan ke sesi
//					session.setAttribute("keranjang", keranjang);
//					response.sendRedirect("/views/restoran/index.jsp");
//				}else{
//					if(command.equals("setCart")){
//						Menu m = new Menu(id_menu, "", 0, 0, 0, "");
//						setCart(m,Integer.parseInt((String) request.getParameter("jumlah")));
//						HttpSession session = request.getSession();
//
//						session.setAttribute("keranjang", keranjang);
//						response.sendRedirect("/shop/index.jsp");
//					}
//				}
//			}
		}
	}

//	private String setCart(Menu m, int s) {
//		// TODO Auto-generated method stub
//		for (Keranjang item : keranjang) {
//			if (item.getMenu().getId_menu() == m.getId_menu()) {
//				item.setJumlah(s);
//				return "keranjang";
//			}
//		}
//		Keranjang k = new Keranjang();
//		k.setMenu(m);;
//		k.setJumlah(s);
//		keranjang.add(k);
//		return "keranjang";
//	}
//
//	private String removeFromCart(Menu m) {
//		// TODO Auto-generated method stub
//		for (Keranjang item : keranjang) {
//			if (item.getMenu().getId_menu() == m.getId_menu()) {
//				keranjang.remove(item);
//				return "keranjang";
//			}
//		}
//		return "keranjang";
//	}
//
//	private String deleteFromCart(Menu m) {
//		// TODO Auto-generated method stub
//		for (Keranjang item : keranjang) {
//			if (item.getMenu().getId_menu() == m.getId_menu() && item.getJumlah() > 1) {
//				item.setJumlah(item.getJumlah() - 1);
//				return "keranjang";
//			}
//		}
//		return "keranjang";
//	}
//
//	private String addToCart(Menu m) {
//		// TODO Auto-generated method stub
//		for (Keranjang item : keranjang) {
//			if (item.getMenu().getId_menu() == m.getId_menu()) {
//				item.setJumlah(item.getJumlah() + 1);
//				return "keranjang";
//			}
//		}
//		Keranjang k = new Keranjang();
//		k.setMenu(m);
//		k.setJumlah(1);
//		keranjang.add(k);
//		return "keranjang";
//	}
//}
