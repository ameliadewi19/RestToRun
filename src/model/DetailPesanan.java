package model;

public class DetailPesanan {
	private Menu menu;
	private int jumlah;
	private Pesanan pesanan;
	
	public DetailPesanan(Menu menu, int jumlah, Pesanan pesanan) {
		super();
		this.menu = menu;
		this.jumlah = jumlah;
		this.pesanan = pesanan;
	}

	public DetailPesanan() {
		// TODO Auto-generated constructor stub
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

	public Pesanan getPesanan() {
		return pesanan;
	}

	public void setPesanan(Pesanan pesanan) {
		this.pesanan = pesanan;
	}	
}
