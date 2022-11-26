package dao;

import java.util.List;

import model.Diskon;

public interface DiskonDAO {
	public void addDiskon(Diskon d);

	public List<Diskon> getList();
}
