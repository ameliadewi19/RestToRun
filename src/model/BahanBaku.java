package model;

public class BahanBaku {
	private char id_bahan;
	private String nama_bahan;
	private int stok;
	
	public BahanBaku(char id_bahan, String nama_bahan, int stok) {
		super();
		this.id_bahan = id_bahan;
		this.nama_bahan = nama_bahan;
		this.stok = stok;
	}

	public char getId_bahan() {
		return id_bahan;
	}

	public void setId_bahan(char id_bahan) {
		this.id_bahan = id_bahan;
	}

	public String getNama_bahan() {
		return nama_bahan;
	}

	public void setNama_bahan(String nama_bahan) {
		this.nama_bahan = nama_bahan;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
}
