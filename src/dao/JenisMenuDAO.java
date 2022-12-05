package dao;

import java.util.List;

import model.JenisMenu;

public interface JenisMenuDAO {
	public void addJenisMenu(JenisMenu jm);

	public List<JenisMenu> getList();
	
	public List<String> getListIDJenis();
}
