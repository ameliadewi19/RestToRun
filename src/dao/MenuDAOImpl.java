package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.JenisMenu;
import model.Menu;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public void addMenu(Menu m) {
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
			CallableStatement createMenu = connection.prepareCall("{call create_menu(?,?,?,?,?,?)}");
			
			//set value to in parameter
			createMenu.setString(1, m.getNama_menu());	
			createMenu.setInt(2, m.getHarga());
			createMenu.setInt(3, m.getEstimasi_waktu());
			createMenu.setInt(4, m.getStok());
			
			createMenu.executeUpdate();			
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
	public List<Menu> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from menu";
		List<Menu> list = new ArrayList<Menu>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_menu = rs.getString("id_menu");
				String nama_menu = rs.getString("nama_menu");
				int harga = rs.getInt("harga");
				int estimasi_waktu = rs.getInt("estimasi_waktu");
				int stok = rs.getInt("stok");
				String jenis = rs.getString("jenis_id_jenis");
				list.add(new Menu(id_menu, nama_menu, harga, estimasi_waktu, stok, jenis));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Menu> getListByCategory(JenisMenu jenis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getMenu(String id_menu) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from menu where id_menu='" + id_menu + "'";
		Menu m = new Menu();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			PreparedStatement ps = (PreparedStatement) connection
						.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id_menu");
				String nama_menu = rs.getString("nama_menu");
				int harga = rs.getInt("harga");
				int estimasi_waktu = rs.getInt("estimasi_waktu");
				int stok = rs.getInt("stok");
				String jenis = rs.getString("jenis_id_jenis");
				System.out.println("\nNama menu: " + nama_menu);
				m = new Menu(id, nama_menu, harga, estimasi_waktu, stok, jenis);
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return m;
	}

	@Override
	public List<Menu> searchList(String nama_menu, JenisMenu jenis) {
		// TODO Auto-generated method stub
		return null;
	}

}
