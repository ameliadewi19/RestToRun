package model;

import java.sql.Timestamp;

public class Diskon {
	private int potongan;
	private Timestamp tanggal_mulai;
	private Timestamp tanggal_akhir;
	private Menu menu;
	
	public Diskon(int potongan, Timestamp tanggal_mulai, Timestamp tanggal_akhir, Menu menu) {
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

	public Timestamp getTanggal_mulai() {
		return tanggal_mulai;
	}

	public void setTanggal_mulai(Timestamp tanggal_mulai) {
		this.tanggal_mulai = tanggal_mulai;
	}

	public Timestamp getTanggal_akhir() {
		return tanggal_akhir;
	}

	public void setTanggal_akhir(Timestamp tanggal_akhir) {
		this.tanggal_akhir = tanggal_akhir;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
