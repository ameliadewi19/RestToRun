package dao;

import java.util.List;

import model.Suplier;

public interface PemasokDAO {
	public void addPemasok(Suplier s);

	public List<Suplier> getList();
}
