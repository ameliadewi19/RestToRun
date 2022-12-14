package dao;

import java.util.List;

import model.Keranjang;

public interface KeranjangDAO {
	public void addKeranjang(Keranjang k);

	public List<Keranjang> getList();
	
	public List<Keranjang> getListPelanggan(String id_pelanggan);
	
	public List<Keranjang> getListPL(String idpl);
}
