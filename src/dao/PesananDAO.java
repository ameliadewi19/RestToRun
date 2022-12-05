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
	
	public void verifikasiPesanan(String idps);
	
	public void kokiMengelola(String idkoki, String idps);
	
	public void kokiMengelolaSelesai(String idps);
	
	public void pelayanMengantarSelesai(String idpelayan, String idps);
	
	public List<PesananView> getListKhusus(String jenis);
}
