package dao;

import java.util.List;

import model.Pelanggan;

public interface PelangganDAO {
	public void addPelanggan(Pelanggan p);

	public List<Pelanggan> getList();
	
	public int getLastId();
}
