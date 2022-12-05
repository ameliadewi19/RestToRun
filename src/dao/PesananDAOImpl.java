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

import model.Pesanan;
import model.PesananView;

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
			CallableStatement createPesanan = connection.prepareCall("{call create_pesanan(?,?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createPesanan.setString(1, p.getId_pesanan());
			createPesanan.setString(2, "Belum Diverifikasi");
			createPesanan.setTimestamp(3, new Timestamp(date.getTime()));
			createPesanan.setString(4, p.getId_pelanggan());
			
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
	public List<PesananView> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from pesanan_view";
		List<PesananView> list = new ArrayList<PesananView>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_pesanan = rs.getString("id_pesanan");
				String id_pelanggan = rs.getString("id_pelanggan");
				String nama_pelanggan = rs.getString("nama_pelanggan");
				String status_pesanan = rs.getString("status_pesanan");
				String waktu = rs.getString("waktu");
				int no_antrian = rs.getInt("no_antrian");
				String id_pelayan = rs.getString("id_pelayan");
				String nama_pelayan = rs.getString("nama_pelayan");
				String id_koki = rs.getString("id_koki");
				String nama_koki = rs.getString("nama_koki");
				list.add(new PesananView(id_pesanan, id_pelanggan, nama_pelanggan, status_pesanan, waktu, no_antrian, id_pelayan, nama_pelayan, id_koki, nama_koki));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getNoAntri() {
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
			CallableStatement createPesanan = connection.prepareCall("{? = call GETNOANTRIAN()}");
			
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
			CallableStatement id = connection.prepareCall("{? = call getLastIDPesanan()}");
			
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

	@Override
	public String getIDPelIDPes(String idpes) {
		// TODO Auto-generated method stub
		String hasil = "";
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
			CallableStatement id = connection.prepareCall("{? = call GETIDPELBYIDPES(?)}");
			
			//set value to in parameter
			id.registerOutParameter(1, Types.VARCHAR);
			id.setString(2, idpes);
			System.out.println("idpes:  " + idpes);
			
			id.executeUpdate();
			hasil = id.getString(1);
			
			System.out.println("hasil:  " + hasil);
			
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

	@Override
	public void verifikasiPesanan(String idps) {
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
			CallableStatement id = connection.prepareCall("{call kasir_update_pesanan(?)}");
			
			//set value to in parameter
			id.setString(1, idps);
			
			id.executeUpdate();
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
	public void kokiMengelola(String idkoki, String idps) {
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
			CallableStatement kokiMengelola = connection.prepareCall("{call create_koki_mengelola(?,?)}");
			
			//set value to in parameter
			kokiMengelola.setString(1, idkoki);
			kokiMengelola.setString(2, idps);
			
			kokiMengelola.executeUpdate();	
			
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
	public void kokiMengelolaSelesai(String idps) {
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
			CallableStatement kokiMengelolaPesanan = connection.prepareCall("{call koki_update_pesanan_finish(?)}");
			
			//set value to in parameter
			kokiMengelolaPesanan.setString(1, idps);
			
			kokiMengelolaPesanan.executeUpdate();	
			
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
	public void pelayanMengantarSelesai(String idpelayan, String idps) {
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
			CallableStatement pelayanMengantarPesanan = connection.prepareCall("{call create_pelayan_mengelola(?,?)}");
			
			//set value to in parameter
			pelayanMengantarPesanan.setString(1, idpelayan);
			pelayanMengantarPesanan.setString(2, idps);
			
			pelayanMengantarPesanan.executeUpdate();	
			
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
	public List<PesananView> getListKhusus(String jenis) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		
		// jenis
		String sql = "";
		if (jenis.equals("koki")) {
			sql = "select * from pesanan_view where status_pesanan = '" + "Sudah Diverifikasi" + "' OR status_pesanan ='" + "Sedang Dimasak" + "' OR status_pesanan = '" + "Selesai Dimasak" + "'";
		} else if (jenis.equals("pelayan")) {
			sql = "select * from pesanan_view where status_pesanan = '" + "Selesai Dimasak" + "' OR status_pesanan ='" + "Selesai Diantar" + "'";
		}
		
		List<PesananView> list = new ArrayList<PesananView>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_pesanan = rs.getString("id_pesanan");
				String id_pelanggan = rs.getString("id_pelanggan");
				String nama_pelanggan = rs.getString("nama_pelanggan");
				String status_pesanan = rs.getString("status_pesanan");
				String waktu = rs.getString("waktu");
				int no_antrian = rs.getInt("no_antrian");
				String id_pelayan = rs.getString("id_pelayan");
				String nama_pelayan = rs.getString("nama_pelayan");
				String id_koki = rs.getString("id_koki");
				String nama_koki = rs.getString("nama_koki");
				list.add(new PesananView(id_pesanan, id_pelanggan, nama_pelanggan, status_pesanan, waktu, no_antrian, id_pelayan, nama_pelayan, id_koki, nama_koki));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
