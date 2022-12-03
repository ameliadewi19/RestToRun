package dao;

import model.Pengguna;

public interface PenggunaDAO {
	
//	public void addUser(Pengguna u);
	
//	public boolean checkUser(String username);
//	
	public boolean login(String email, String password);
//	
//	public void updateUser(User u);
//	
//	public User getUser(String username);

 	public String getJenis(String email);
 	
 	public String getNamaUser(String email);
 	
 	public String getIdPelangganByEmail(String email);
}
