package model;

public class Pengguna {
	private char id_pengguna;
	private String password;
	private char id_jenis;
	private String email;
	private String nama;
	private char jenis_kelamin;
	private String alamat;
	
	public Pengguna(char id_pengguna, String password, char id_jenis, String email, String nama, char jenis_kelamin,
			String alamat) {
		super();
		this.id_pengguna = id_pengguna;
		this.password = password;
		this.id_jenis = id_jenis;
		this.email = email;
		this.nama = nama;
		this.jenis_kelamin = jenis_kelamin;
		this.alamat = alamat;
	}

	public char getId_pengguna() {
		return id_pengguna;
	}

	public void setId_pengguna(char id_pengguna) {
		this.id_pengguna = id_pengguna;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getId_jenis() {
		return id_jenis;
	}

	public void setId_jenis(char id_jenis) {
		this.id_jenis = id_jenis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public char getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(char jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
