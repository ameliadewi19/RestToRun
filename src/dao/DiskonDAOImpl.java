package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Diskon;
import model.Menu;

public class DiskonDAOImpl implements DiskonDAO{

	@Override
	public void addDiskon(Diskon d) {
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
			CallableStatement createDiskon = connection.prepareCall("{call create_diskon(?,?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createDiskon.setInt(1, d.getPotongan());
			createDiskon.setTime(2, new Time(date.getTime()));
			createDiskon.setTime(3, new Time(date.getTime()));
			createDiskon.setString(4, d.getMenu().getId_menu());
			
			createDiskon.executeUpdate();			
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
	public List<Diskon> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from diskon";
		List<Diskon> list = new ArrayList<Diskon>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int potongan = rs.getInt("potongan");
				String tanggal_mulai = rs.getString("tanggal_mulai");
				String tanggal_akhir = rs.getString("tanggal_akhir");
				String menu_id_menu = rs.getString("menu_id_menu");
				Menu menu = new Menu();
				menu.setId_menu(menu_id_menu);
				list.add(new Diskon(potongan, tanggal_mulai, tanggal_akhir, menu));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
