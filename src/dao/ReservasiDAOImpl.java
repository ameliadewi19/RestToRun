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

import model.InvoiceView;
import model.Reservasi;

public class ReservasiDAOImpl implements ReservasiDAO{
	public void addReservasi(Reservasi r) {
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
			CallableStatement createReservasi = connection.prepareCall("{call create_reservasi(?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createReservasi.setString(1, r.getId_reservasi());
			createReservasi.setString(2, r.getWaktu());
			createReservasi.setString(3, r.getId_pesanan());
			
			createReservasi.executeUpdate();			
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

	public List<Reservasi> getList(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from reservasi";
		List<Reservasi> list = new ArrayList<Reservasi>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_reservasi = rs.getString("id_reservasi");
				String waktu = rs.getString("waktu");
				String id_pesanan = rs.getString("pesanan_id_pesanan");
				list.add(new Reservasi(id_reservasi, waktu, id_pesanan));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
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
			CallableStatement id = connection.prepareCall("{? = call getLastIDReservasi()}");
			
			//set value to in parameter
			id.registerOutParameter(1, Types.INTEGER);
			
			id.executeUpdate();
			hasil = id.getInt(1);
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