package model;

public class Diskon {
	private int potongan;
	private String tanggal_mulai;
	private String tanggal_akhir;
	private Menu menu;
	
	public Diskon(int potongan, String tanggal_mulai, String tanggal_akhir, Menu menu) {
		super();
		this.potongan = potongan;
		this.tanggal_mulai = tanggal_mulai;
		this.tanggal_akhir = tanggal_akhir;
		this.menu = menu;
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}	
}
