package model;

public class Pelanggan {
	private char id_pelanggan;
	private String nama;
	private String no_telp;
	
	public Pelanggan(char id_pelanggan, String nama, String no_telp) {
		super();
		this.id_pelanggan = id_pelanggan;
		this.nama = nama;
		this.no_telp = no_telp;
	}

	public char getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(char id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}
}
