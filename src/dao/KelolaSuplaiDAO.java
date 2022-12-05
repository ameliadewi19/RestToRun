package dao;

import java.util.List;

import model.KelolaSuplai;;

public interface KelolaSuplaiDAO {
	public void addKelolaSuplai(KelolaSuplai k);

	public List<KelolaSuplai> getList();
}
