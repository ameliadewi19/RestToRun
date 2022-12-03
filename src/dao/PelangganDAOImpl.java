package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Pelanggan;

public class PelangganDAOImpl implements PelangganDAO{

	@Override
	public void addPelanggan(Pelanggan p) {
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
			CallableStatement createPelanggan = connection.prepareCall("{call create_pelanggan(?,?,?)}");
			
			//set value to in parameter
			createPelanggan.setString(1, p.getId_pelanggan());
			createPelanggan.setString(2, p.getNama());
			createPelanggan.setString(3, p.getNo_telp());
			
			createPelanggan.executeUpdate();			
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
	public List<Pelanggan> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getLastId() {
		int hasil = 0;
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
			CallableStatement createPesanan = connection.prepareCall("{? = call getLastIDPelanggan()}");
			
			//set value to in parameter
			createPesanan.registerOutParameter(1, Types.INTEGER);
			
			createPesanan.executeUpdate();
			hasil = createPesanan.getInt(1);
			connection.close();  
			
			}catch(Exception e){ 
				e.printStackTrace();
			}
		if (connection != null) {
			System.out.println("\nSuccessfullly connected to Oracle DB");
		} else {
			System.out.println("\nFailed to connect to Oracle DB");
		}
		
		return hasil;
	}
}
