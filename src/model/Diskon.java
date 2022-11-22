package model;

public class Diskon {
	private int potongan;
	private String tanggal_mulai;
	private String tanggal_akhir;
	private char id_menu;
	
	public Diskon(int potongan, String tanggal_mulai, String tanggal_akhir, char id_menu) {
		super();
		this.potongan = potongan;
		this.tanggal_mulai = tanggal_mulai;
		this.tanggal_akhir = tanggal_akhir;
		this.id_menu = id_menu;
	}

	public int getPotongan() {
		return potongan;
	}

	public void setPotongan(int potongan) {
		this.potongan = potongan;
	}

	public String getTanggal_mulai() {
		return tanggal_mulai;
	}

	public void setTanggal_mulai(String tanggal_mulai) {
		this.tanggal_mulai = tanggal_mulai;
	}

	public String getTanggal_akhir() {
		return tanggal_akhir;
	}

	public void setTanggal_akhir(String tanggal_akhir) {
		this.tanggal_akhir = tanggal_akhir;
	}

	public char getId_menu() {
		return id_menu;
	}

	public void setId_menu(char id_menu) {
		this.id_menu = id_menu;
	}
	
	
}
