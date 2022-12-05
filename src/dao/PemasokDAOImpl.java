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

import model.Suplier;

public class PemasokDAOImpl implements PemasokDAO{

	@Override
	public void addPemasok(Suplier s) {
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
			CallableStatement createSuplier = connection.prepareCall("{call create_suplier(?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createSuplier.setString(1, s.getNama());
			createSuplier.setString(2, s.getAlamat());
			
			createSuplier.executeUpdate();			
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
	public List<Suplier> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from suplier";
		List<Suplier> list = new ArrayList<Suplier>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_suplier = rs.getString("id_suplier");
				String nama = rs.getString("nama");
				String alamat = rs.getString("alamat");
				list.add(new Suplier(id_suplier, nama, alamat));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
