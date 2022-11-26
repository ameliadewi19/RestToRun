package dao;

import java.util.List;

import model.BahanBaku;

public interface BahanDAO {
	public void addBahanBaku(BahanBaku b);

	public List<BahanBaku> getList();
}
