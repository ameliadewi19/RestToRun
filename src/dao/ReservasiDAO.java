package dao;

import java.util.List;

import model.Reservasi;

public interface ReservasiDAO {
	public void addReservasi(Reservasi r);

	public List<Reservasi> getList();
}