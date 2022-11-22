package dao;

import java.util.List;

import model.Menu;
import model.JenisMenu;

public interface MenuDAO {
	public void addMenu(Menu m);

	public List<Menu> getList();

	public List<Menu> getListByCategory(JenisMenu jenis);
	
	public Menu getMenu(String id_menu);
		
	public List<Menu> searchList(String nama_menu, JenisMenu jenis);
	
}