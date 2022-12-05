package model;

public class JenisMenu {
	private String id_jenis;
	private String nama_jenis;
	
	
	public JenisMenu(String id_jenis, String nama_jenis) {
		super();
		this.id_jenis = id_jenis;
		this.nama_jenis = nama_jenis;
	}


	public JenisMenu() {
		// TODO Auto-generated constructor stub
	}


	public String getId_jenis() {
		return id_jenis;
	}


	public void setId_jenis(String id_jenis) {
		this.id_jenis = id_jenis;
	}


	public String getNama_jenis() {
		return nama_jenis;
	}


	public void setNama_jenis(String nama_jenis) {
		this.nama_jenis = nama_jenis;
	}
		
}
