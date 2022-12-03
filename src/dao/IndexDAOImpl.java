package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.Types;

public class IndexDAOImpl implements IndexDAO{

	@Override
	public int getPesananHariIni() {
		// TODO Auto-generated method stub
		int hasil = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		System.out.println("\ncoba: ");
		try {			
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			//create callable statement
			CallableStatement getReservasiHariIni = connection.prepareCall("{? = call GETJUMLAHPESANANHARIINI()}");
			
			//set value to in parameter
			getReservasiHariIni.registerOutParameter(1, Types.INTEGER);
			getReservasiHariIni.executeUpdate();		
			
			hasil = getReservasiHariIni.getInt(1);
			System.out.println("\nPesanan: " + hasil);
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
	public int getPesanan() {
		// TODO Auto-generated method stub
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
			CallableStatement getReservasi = connection.prepareCall("{? = call GETTOTALPESANAN()}");
			
			//set value to in parameter
			getReservasi.registerOutParameter(1, Types.INTEGER);
			getReservasi.executeUpdate();		
			
			hasil = getReservasi.getInt(1);
			System.out.println("\nPesanan Total: " + hasil);
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
	public int getReservasiHariIni() {
		// TODO Auto-generated method stub
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
			CallableStatement getReservasi = connection.prepareCall("{? = call GETTOTALRESERVASIHARIINI()}");
			
			//set value to in parameter
			getReservasi.registerOutParameter(1, Types.INTEGER);
			getReservasi.executeUpdate();		
			
			hasil = getReservasi.getInt(1);
			System.out.println("\nReservasi: " + hasil);
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

	public int getReservasi() {
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
			CallableStatement getReservasiHariIni = connection.prepareCall("{? = call GETTOTALRESERVASI()}");
			
			//set value to in parameter
			getReservasiHariIni.registerOutParameter(1, Types.INTEGER);
			getReservasiHariIni.executeUpdate();		
			
			hasil = getReservasiHariIni.getInt(1);
			System.out.println("\nReservasi Total: " + hasil);
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
