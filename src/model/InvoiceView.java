package model;

public class InvoiceView {
	private String id_invoice;
	private int jumlah;
	private String id_kasir;
	private String nama_kasir;
	private String status_pembayaran;
	private String id_pesanan;
	private String id_pelanggan;
	private String nama_pelanggan;
	
	public InvoiceView(String id_invoice, int jumlah, String id_kasir, String nama_kasir, String status_pembayaran,
			String id_pesanan, String id_pelanggan, String nama_pelanggan) {
		super();
		this.id_invoice = id_invoice;
		this.jumlah = jumlah;
		this.id_kasir = id_kasir;
		this.nama_kasir = nama_kasir;
		this.status_pembayaran = status_pembayaran;
		this.id_pesanan = id_pesanan;
		this.id_pelanggan = id_pelanggan;
		this.nama_pelanggan = nama_pelanggan;
	}

	public String getId_invoice() {
		return id_invoice;
	}

	public void setId_invoice(String id_invoice) {
		this.id_invoice = id_invoice;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public String getId_kasir() {
		return id_kasir;
	}

	public void setId_kasir(String id_kasir) {
		this.id_kasir = id_kasir;
	}

	public String getNama_kasir() {
		return nama_kasir;
	}

	public void setNama_kasir(String nama_kasir) {
		this.nama_kasir = nama_kasir;
	}

	public String getStatus_pembayaran() {
		return status_pembayaran;
	}

	public void setStatus_pembayaran(String status_pembayaran) {
		this.status_pembayaran = status_pembayaran;
	}

	public String getId_pesanan() {
		return id_pesanan;
	}

	public void setId_pesanan(String id_pesanan) {
		this.id_pesanan = id_pesanan;
	}

	public String getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public String getNama_pelanggan() {
		return nama_pelanggan;
	}

	public void setNama_pelanggan(String nama_pelanggan) {
		this.nama_pelanggan = nama_pelanggan;
	}
}
