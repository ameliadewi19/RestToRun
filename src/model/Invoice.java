package model;

public class Invoice {
	private char id_invoice;
	private int jumlah;
	private char id_kasir;
	private String status_pembayaran;
	private char id_pesanan;
	
	public Invoice(char id_invoice, int jumlah, char id_kasir, String status_pembayaran, char id_pesanan) {
		super();
		this.id_invoice = id_invoice;
		this.jumlah = jumlah;
		this.id_kasir = id_kasir;
		this.status_pembayaran = status_pembayaran;
		this.id_pesanan = id_pesanan;
	}

	public char getId_invoice() {
		return id_invoice;
	}

	public void setId_invoice(char id_invoice) {
		this.id_invoice = id_invoice;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public char getId_kasir() {
		return id_kasir;
	}

	public void setId_kasir(char id_kasir) {
		this.id_kasir = id_kasir;
	}

	public String getStatus_pembayaran() {
		return status_pembayaran;
	}

	public void setStatus_pembayaran(String status_pembayaran) {
		this.status_pembayaran = status_pembayaran;
	}

	public char getId_pesanan() {
		return id_pesanan;
	}

	public void setId_pesanan(char id_pesanan) {
		this.id_pesanan = id_pesanan;
	}
}
