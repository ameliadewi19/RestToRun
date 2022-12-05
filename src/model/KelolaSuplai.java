package model;

public class KelolaSuplai {
	private BahanBaku bahanbaku;
	private Suplier suplier;
	private Pengguna pengguna;
	public KelolaSuplai(BahanBaku bahanbaku, Suplier suplier, Pengguna pengguna) {
		super();
		this.bahanbaku = bahanbaku;
		this.suplier = suplier;
		this.pengguna = pengguna;
	}
	public KelolaSuplai(String tanggal, int jumlah, BahanBaku bahanBaku2, Suplier suplier2, Pengguna pengguna2) {
		// TODO Auto-generated constructor stub
	}
	public BahanBaku getBahanbaku() {
		return bahanbaku;
	}
	public void setBahanbaku(BahanBaku bahanbaku) {
		this.bahanbaku = bahanbaku;
	}
	public Suplier getSuplier() {
		return suplier;
	}
	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}
	public Pengguna getPengguna() {
		return pengguna;
	}
	public void setPengguna(Pengguna pengguna) {
		this.pengguna = pengguna;
	}
}
