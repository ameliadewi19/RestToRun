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

import model.InvoiceView;
import model.Reservasi;

public class ReservasiDAOImpl {
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
			CallableStatement createPesanan = connection.prepareCall("{call create_reservasi(?,?,?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
//			createPesanan.setString(1, "Belum Diverifikasi");
//			createPesanan.setTimestamp(2, new Timestamp(date.getTime()));
//			createPesanan.setString(3, p.getId_pelanggan());
//			createPesanan.setInt(4, p.getNo_antrian());
			
			createPesanan.executeUpdate();			
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
}