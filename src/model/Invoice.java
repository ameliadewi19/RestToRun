package model;

public class Invoice {
	private String id_invoice;
	private int jumlah;
	private String id_kasir;
	private String status_pembayaran;
	private String id_pesanan;
	private float jumlah_akhir;
	private float jumlah_potongan;
	private float jumlah_bayar;
	private float jumlah_kembalian;
	private String metode_pembayaran;
	
	public Invoice(String id_invoice, int jumlah, String id_kasir, String status_pembayaran, String id_pesanan,
			float jumlah_akhir, float jumlah_potongan, float jumlah_bayar, float jumlah_kembalian,
			String metode_pembayaran) {
		super();
		this.id_invoice = id_invoice;
		this.jumlah = jumlah;
		this.id_kasir = id_kasir;
		this.status_pembayaran = status_pembayaran;
		this.id_pesanan = id_pesanan;
		this.jumlah_akhir = jumlah_akhir;
		this.jumlah_potongan = jumlah_potongan;
		this.jumlah_bayar = jumlah_bayar;
		this.jumlah_kembalian = jumlah_kembalian;
		this.metode_pembayaran = metode_pembayaran;
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
	public float getJumlah_akhir() {
		return jumlah_akhir;
	}
	public void setJumlah_akhir(float jumlah_akhir) {
		this.jumlah_akhir = jumlah_akhir;
	}
	public float getJumlah_potongan() {
		return jumlah_potongan;
	}
	public void setJumlah_potongan(float jumlah_potongan) {
		this.jumlah_potongan = jumlah_potongan;
	}
	public float getJumlah_bayar() {
		return jumlah_bayar;
	}
	public void setJumlah_bayar(float jumlah_bayar) {
		this.jumlah_bayar = jumlah_bayar;
	}
	public float getJumlah_kembalian() {
		return jumlah_kembalian;
	}
	public void setJumlah_kembalian(float jumlah_kembalian) {
		this.jumlah_kembalian = jumlah_kembalian;
	}
	public String getMetode_pembayaran() {
		return metode_pembayaran;
	}
	public void setMetode_pembayaran(String metode_pembayaran) {
		this.metode_pembayaran = metode_pembayaran;
	}
	
	
}
