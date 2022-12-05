package model;

public class Suplier {
	private String id_suplier;
	private String nama;
	private String alamat;
	
	public Suplier(String id_suplier, String nama, String alamat) {
		super();
		this.id_suplier = id_suplier;
		this.nama = nama;
		this.alamat = alamat;
	}

	public Suplier() {
		// TODO Auto-generated constructor stub
	}

	public String getId_suplier() {
		return id_suplier;
	}

	public void setId_suplier(String id_suplier) {
		this.id_suplier = id_suplier;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
