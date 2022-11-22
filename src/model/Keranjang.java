package model;

public class Keranjang {
	private Menu menu;
	private int jumlah;
	
	public Keranjang() {
	}
	
	public Keranjang(Menu menu, int jumlah) {
		super();
		this.menu = menu;
		this.jumlah = jumlah;
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
}
