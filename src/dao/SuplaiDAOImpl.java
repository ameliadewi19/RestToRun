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
import model.Menyuplai;
import model.Suplier;

public class SuplaiDAOImpl implements SuplaiDAO{

	@Override
	public void addSuplai(Menyuplai m) {
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
			CallableStatement createSuplai = connection.prepareCall("{call create_suplai(?,?)}");
			
			//set value to in parameter
			createSuplai.setString(1, m.getBahanbaku().getId_bahan());
			createSuplai.setString(2, m.getSuplier().getId_suplier());
			
			createSuplai.executeUpdate();			
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
	public List<Menyuplai> getList() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String sql = "select * from menyuplai";
		List<Menyuplai> list = new ArrayList<Menyuplai>();
		try {
			//establish the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","restaurant","restaurant");
			
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String bahanbaku_id_bahan = rs.getString("bahanbaku_id_bahan");
				String suplier_id_suplier = rs.getString("suplier_id_suplier");
		
				BahanBaku bahanBaku= new BahanBaku();
				bahanBaku.setId_bahan(bahanbaku_id_bahan);
				Suplier suplier= new Suplier();
				suplier.setId_suplier(suplier_id_suplier);
				
				list.add(new Menyuplai(bahanBaku, suplier));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
