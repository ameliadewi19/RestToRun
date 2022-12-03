package model;

public class Keranjang {
	private Menu menu;
	private int jumlah;
	private Pelanggan pelanggan;

	public Keranjang(Menu menu, int jumlah, Pelanggan pelanggan) {
		super();
		this.menu = menu;
		this.jumlah = jumlah;
		this.pelanggan = pelanggan;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public Pelanggan getPelanggan() {
		return pelanggan;
	}

	public void setPelanggan(Pelanggan pelanggan) {
		this.pelanggan = pelanggan;
	}
}
