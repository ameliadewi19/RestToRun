package dao;

import java.util.List;

import model.Pesanan;
import model.PesananView;

public interface PesananDAO {
	public void addPesanan(Pesanan p);

	public List<PesananView> getList();
	
	public int getNoAntri();
	
	public int getLastId();
	
	public String getIDPelIDPes(String idpes);
}
