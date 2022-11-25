package dao;

import java.util.List;

import model.Pesanan;

public interface PesananDAO {
	public void addPesanan(Pesanan p);

	public List<Pesanan> getList();
}
