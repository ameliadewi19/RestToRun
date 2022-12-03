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

import model.Keranjang;
import model.Menu;
import model.Pelanggan;

public class KeranjangDAOImpl implements KeranjangDAO{

	@Override
	public void addKeranjang(Keranjang k) {
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
			CallableStatement createKeranjang = connection.prepareCall("{call create_keranjang(?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createKeranjang.setString(1, k.getMenu().getId_menu());
			createKeranjang.setInt(2, k.getJumlah());
			createKeranjang.setString(3, k.getPelanggan().getId_pelanggan());
			
			createKeranjang.executeUpdate();			
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
	public List<Keranjang> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from keranjang";
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
}
