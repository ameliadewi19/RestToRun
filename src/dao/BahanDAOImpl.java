package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BahanBaku;

public class BahanDAOImpl implements BahanDAO{

	@Override
	public void addBahanBaku(BahanBaku b) {
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
			CallableStatement createBahan = connection.prepareCall("{call create_bahan(?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createBahan.setString(1, b.getId_bahan());
			createBahan.setString(2, b.getNama_bahan());
			createBahan.setInt(3, b.getStok());
			
			createBahan.executeUpdate();			
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
	public List<BahanBaku> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from bahanbaku";
		List<BahanBaku> list = new ArrayList<BahanBaku>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_bahan = rs.getString("id_bahan");
				String nama_bahan = rs.getString("nama_bahan");
				int stok = rs.getInt("stok");
				list.add(new BahanBaku(id_bahan, nama_bahan, stok));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
