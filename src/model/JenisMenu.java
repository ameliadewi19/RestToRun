package model;

public class JenisMenu {
	private char id_jenis;
	private String nama_jenis;
	
	
	public JenisMenu(char id_jenis, String nama_jenis) {
		super();
		this.id_jenis = id_jenis;
		this.nama_jenis = nama_jenis;
	}


	public char getId_jenis() {
		return id_jenis;
	}


	public void setId_jenis(char id_jenis) {
		this.id_jenis = id_jenis;
	}


	public String getNama_jenis() {
		return nama_jenis;
	}


	public void setNama_jenis(String nama_jenis) {
		this.nama_jenis = nama_jenis;
	}
		
}
