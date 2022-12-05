package model;

public class Menu {
	private String id_menu;
	private String nama_menu;
	private int harga;
	private int estimasi_waktu;
	private int stok;
	private JenisMenu jenis_menu;
	
	public Menu(String id_menu, String nama_menu, int harga, int estimasi_waktu, int stok, JenisMenu jenis_menu) {
		super();
		this.id_menu = id_menu;
		this.nama_menu = nama_menu;
		this.harga = harga;
		this.estimasi_waktu = estimasi_waktu;
		this.stok = stok;
		this.jenis_menu = jenis_menu;
	}

	public Menu() {
		// TODO Auto-generated constructor stub
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

	public JenisMenu getJenis_menu() {
		return jenis_menu;
	}

	public void setJenis_menu(JenisMenu jenis_menu) {
		this.jenis_menu = jenis_menu;
	}	
}
