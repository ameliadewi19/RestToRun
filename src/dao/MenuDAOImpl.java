package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
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
			createMenu.setString(1, m.getId_jenis());
			createMenu.setString(2, m.getNama_menu());	
			createMenu.setInt(3, m.getHarga());
			createMenu.setInt(4, m.getEstimasi_waktu());
			createMenu.setInt(5, m.getStok());
			
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
		return null;
	}

	@Override
	public List<Menu> getListByCategory(JenisMenu jenis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getMenu(String id_menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> searchList(String nama_menu, JenisMenu jenis) {
		// TODO Auto-generated method stub
		return null;
	}

}
