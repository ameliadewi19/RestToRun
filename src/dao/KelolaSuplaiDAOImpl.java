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
import java.sql.Date;

import model.BahanBaku;
import model.Keranjang;
import model.Menu;
import model.Pelanggan;
import model.Pengguna;
import model.Suplier;
import model.KelolaSuplai;

public class KelolaSuplaiDAOImpl implements KelolaSuplaiDAO{

	@Override
	public void addKelolaSuplai(KelolaSuplai k) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {			
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			//create callable statement
			CallableStatement createkelolaSuplai = connection.prepareCall("{call create_kelolaSuplai(?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			
			// get id pengguna
			Pengguna pengguna = new Pengguna();
			String idPengguna = pengguna.getId_pengguna();
			
			createkelolaSuplai.setString(1, k.getBahanbaku().getId_bahan());
			createkelolaSuplai.setString(2, k.getSuplier().getId_suplier());
			createkelolaSuplai.setString(3, k.getPengguna().getId_pengguna());
			
			createkelolaSuplai.executeUpdate();			
			connection.close();
			
			}catch(Exception e){ 
				e.printStackTrace();
			}
		if (connection != null) {
			System.out.println("\nSuccessfullly connected to Oracle DB");
		} else {
			System.out.println("\nFailed to connect to Oracle DB");
		}
	}

	@Override
	public List<KelolaSuplai> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from mengelolasuplai";
		List<KelolaSuplai> list = new ArrayList<KelolaSuplai>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tanggal = rs.getString("tanggal");
				int jumlah = rs.getInt("jumlah");
				String menyuplai_bahanbaku_id_bahan = rs.getString("menyuplai_bahanbaku_id_bahan");
				String menyuplai_suplier_id_suplier = rs.getString("menyuplai_suplier_id_suplier");
				String stafgudang_id_staf_gudang = rs.getString("stafgudang_id_staf_gudang");
				
				BahanBaku bahanBaku= new BahanBaku();
				bahanBaku.setId_bahan(menyuplai_bahanbaku_id_bahan);
				Pengguna pengguna= new Pengguna();
				pengguna.setId_pengguna(stafgudang_id_staf_gudang);
				Suplier suplier= new Suplier();
				suplier.setId_suplier(menyuplai_suplier_id_suplier);
				
				list.add(new KelolaSuplai(tanggal, jumlah, bahanBaku, suplier, pengguna));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<Keranjang> getListPelanggan(String id_pelanggan) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from keranjang where pelanggan_id_pelanggan='" + id_pelanggan + "'";
		List<Keranjang> list = new ArrayList<Keranjang>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_menu = rs.getString("id_menu");
				int jumlah = rs.getInt("jumlah");
				String id_pelanggan2 = rs.getString("pelanggan_id_pelanggan");
				Menu menu = new Menu();
				menu.setId_menu(id_menu);
				Pelanggan pelanggan = new Pelanggan();
				pelanggan.setId_pelanggan(id_pelanggan2);
				list.add(new Keranjang(menu, jumlah, pelanggan));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Keranjang> getListPL(String idpl) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from keranjang where pelanggan_id_pelanggan='" + idpl + "'";
		List<Keranjang> list = new ArrayList<Keranjang>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_menu = rs.getString("id_menu");
				int jumlah = rs.getInt("jumlah");
				String id_pelanggan = rs.getString("pelanggan_id_pelanggan");
				Menu menu = new Menu();
				menu.setId_menu(id_menu);
				Pelanggan pelanggan = new Pelanggan();
				pelanggan.setId_pelanggan(id_pelanggan);
				list.add(new Keranjang(menu, jumlah, pelanggan));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
