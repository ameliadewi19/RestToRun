package dao;

import java.util.List;

import model.JenisUser;

public interface JenisUserDAO {
	public void addJenisUser(JenisUser ju);

	public List<JenisUser> getList();
}
