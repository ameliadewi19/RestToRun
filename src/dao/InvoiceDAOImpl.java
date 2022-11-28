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

import model.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO{

	@Override
	public void addInvoice(Invoice i) {
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
			CallableStatement createInvoice = connection.prepareCall("{call create_invoice(?,?,?,?,?)}");
			
			java.util.Date date = new java.util.Date();
			//set value to in parameter
			createInvoice.setString(1, i.getId_invoice());
			createInvoice.setInt(2, i.getJumlah());
			createInvoice.setString(3, i.getId_kasir());
			createInvoice.setString(4, i.getStatus_pembayaran());
			createInvoice.setString(5, i.getId_pesanan());
			
			createInvoice.executeUpdate();			
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
	public List<Invoice> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from invoice";
		List<Invoice> list = new ArrayList<Invoice>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id_invoice = rs.getString("id_invoice");
				int jumlah = rs.getInt("jumlah");
				String id_kasir = rs.getString("id_kasir");
				String status_pembayaran = rs.getString("status_pembayaran");
				String id_pesanan = rs.getString("id_pesanan");
				list.add(new Invoice(id_invoice, jumlah, id_kasir, status_pembayaran, id_pesanan));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
