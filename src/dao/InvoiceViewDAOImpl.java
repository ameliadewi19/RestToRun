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

import model.InvoiceView;

public class InvoiceViewDAOImpl implements InvoiceViewDAO{

	@Override
	public List<InvoiceView> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from invoice_view";
		List<InvoiceView> list = new ArrayList<InvoiceView>();
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
				String nama_kasir = rs.getString("nama_kasir");
				String status_pembayaran = rs.getString("status_pembayaran");
				String id_pesanan = rs.getString("id_pesanan");
				String id_pelanggan = rs.getString("id_pelanggan");
				String nama_pelanggan = rs.getString("nama_pelanggan");
				list.add(new InvoiceView(id_invoice, jumlah, id_kasir, nama_kasir, status_pembayaran, id_pesanan, id_pelanggan, nama_pelanggan));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
