package dao;

import java.util.List;

import model.Menyuplai;

public interface SuplaiDAO {
	public void addSuplai(Menyuplai m);

	public List<Menyuplai> getList();
}
