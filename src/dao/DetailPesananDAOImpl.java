package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.DetailPesanan;
import model.Keranjang;
import model.Menu;
import model.Pesanan;
import model.PesananView;

public class DetailPesananDAOImpl implements DetailPesananDAO{
	
	@Override
	public void addDetailPesanan(DetailPesanan dp) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			//create callable statement
			CallableStatement createDetail = con.prepareCall("{call create_detail_pesanan(?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createDetail.setString(1, dp.getPesanan().getId_pesanan());
			createDetail.setString(2, dp.getMenu().getId_menu());
			createDetail.setInt(3, dp.getJumlah());
			
			createDetail.executeUpdate();	
			
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addDetailPesananAll(String idpl, String idps) {				
		List<Keranjang> list = new ArrayList<Keranjang>();
		KeranjangDAOImpl keranjangDAO = new KeranjangDAOImpl();
		
		for (Keranjang k : keranjangDAO.getListPL(idpl)) {
			System.out.println("\nid menu: " + k.getMenu().getId_menu());
			System.out.println("jumlah: " + k.getJumlah());
			System.out.println("id pel: " + k.getPelanggan().getId_pelanggan());
			System.out.println("idpl: " + idps);
		}
		
		DetailPesananDAOImpl detailDAO = new DetailPesananDAOImpl();
		DetailPesanan detail = new DetailPesanan();
		Pesanan pesanan = new Pesanan();
		Menu menu = new Menu();

			for (Keranjang k : keranjangDAO.getListPL(idpl)) {
				pesanan.setId_pesanan(idps);
				detail.setPesanan(pesanan);
				System.out.println("idps: " + detail.getPesanan().getId_pesanan());
				menu.setId_menu(k.getMenu().getId_menu());
				detail.setMenu(menu);
				detail.setJumlah(k.getJumlah());
				
				detailDAO.addDetailPesanan(detail);
			}
	}
	
}
 