package dao;

import model.DetailPesanan;

public interface DetailPesananDAO {
	
	public void addDetailPesanan(DetailPesanan dp);
	
	public void addDetailPesananAll(String idpl, String idps);
}
