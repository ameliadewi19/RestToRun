package dao;

import model.Pengguna;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class PenggunaDAOImpl implements PenggunaDAO {

	public static void main(String[] args) {
		PenggunaDAOImpl dao = new PenggunaDAOImpl();
		System.out.println(dao.login("admin", "12345"));
	}

	@Override
	public boolean login(String email, String password) {
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
			CallableStatement login = connection.prepareCall("{? = call login(?,?)}");
			
			//register out parameter
			login.registerOutParameter(1, Types.INTEGER);
			
			//set value to in parameter
			login.setString(2, email);
			login.setString(3, password);	
			
			login.executeUpdate();
			int hasil = login.getInt(1);
			System.out.println("Hasil:" + hasil);
				
			if(hasil == 1) {
				return true;
			}			
			connection.close();  
			}catch(Exception e){ 
				e.printStackTrace();
			}
		if (connection != null) {
			System.out.println("\nSuccessfullly connected to Oracle DB");
		} else {
			System.out.println("\nFailed to connect to Oracle DB");
		}
		return false;
	}

	@Override
	public String getJenis(String email) {
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
			CallableStatement jenis = connection.prepareCall("{? = call getJenisUser(?)}");
			
			//register out parameter
			jenis.registerOutParameter(1, Types.VARCHAR);
			
			//set value to in parameter
			jenis.setString(2, email);
			
			jenis.executeUpdate();
			hasil = jenis.getString(1);
			System.out.println("Hasil:" + hasil);
				
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
	
	public String getNamaUser(String email) {
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
			CallableStatement nama = connection.prepareCall("{? = call getNama(?)}");
			
			//register out parameter
			nama.registerOutParameter(1, Types.VARCHAR);
			
			//set value to in parameter
			nama.setString(2, email);
			
			nama.executeUpdate();
			hasil = nama.getString(1);
			System.out.println("Hasil nama: " + nama);
				
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
