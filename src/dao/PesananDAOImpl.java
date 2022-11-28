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

import model.Pesanan;

public class PesananDAOImpl implements PesananDAO{

	@Override
	public void addPesanan(Pesanan p) {
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
			CallableStatement createPesanan = connection.prepareCall("{call create_pesanan(?,?,?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createPesanan.setString(1, "Belum Diverifikasi");
			createPesanan.setTimestamp(2, new Timestamp(date.getTime()));
			createPesanan.setString(3, p.getId_pelanggan());
			createPesanan.setInt(4, p.getNo_antrian());
			
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

	@Override
	public List<Pesanan> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from pesanan";
		List<Pesanan> list = new ArrayList<Pesanan>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_pesanan = rs.getString("id_pesanan");
				String status_pesanan = rs.getString("status_pesanan");
				Timestamp waktu = rs.getTimestamp("waktu");
				String id_pelanggan = rs.getString("pelanggan_id_pelanggan");
				int no_antrian = rs.getInt("no_antrian");
				list.add(new Pesanan(id_pesanan, status_pesanan, waktu, id_pelanggan, no_antrian));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
