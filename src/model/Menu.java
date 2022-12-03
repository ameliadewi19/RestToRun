package model;

public class Menu {
	private String id_menu;
	private String nama_menu;
	private int harga;
	private int estimasi_waktu;
	private int stok;
	private String id_jenis;
	
	public Menu(String id_menu, String nama_menu, int harga, int estimasi_waktu, int stok, String id_jenis) {
		super();
		this.id_menu = id_menu;
		this.nama_menu = nama_menu;
		this.harga = harga;
		this.estimasi_waktu = estimasi_waktu;
		this.stok = stok;
		this.id_jenis = id_jenis;
	}

	public Menu() {
		
	}

	public String getId_menu() {
		return id_menu;
	}

	public void setId_menu(String id_menu) {
		this.id_menu = id_menu;
	}

	public String getNama_menu() {
		return nama_menu;
	}

	public void setNama_menu(String nama_menu) {
		this.nama_menu = nama_menu;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getEstimasi_waktu() {
		return estimasi_waktu;
	}

	public void setEstimasi_waktu(int estimasi_waktu) {
		this.estimasi_waktu = estimasi_waktu;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public String getId_jenis() {
		return id_jenis;
	}

	public void setId_jenis(String id_jenis) {
		this.id_jenis = id_jenis;
	}
	
}
