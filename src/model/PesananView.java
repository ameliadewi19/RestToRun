package model;

public class PesananView {
	String id_pesanan;
	String id_pelanggan;
	String nama_pelanggan;
	String status_pesanan;
	String waktu;
	int no_antrian;
	String id_pelayan;
	String nama_pelayan;
	String id_koki;
	String nama_koki;
	
	public PesananView(String id_pesanan, String id_pelanggan, String nama_pelanggan, String status_pesanan,
			String waktu, int no_antrian, String id_pelayan, String nama_pelayan, String id_koki, String nama_koki) {
		this.id_pesanan = id_pesanan;
		this.id_pelanggan = id_pelanggan;
		this.nama_pelanggan = nama_pelanggan;
		this.status_pesanan = status_pesanan;
		this.waktu = waktu;
		this.no_antrian = no_antrian;
		this.id_pelayan = id_pelayan;
		this.nama_pelayan = nama_pelayan;
		this.id_koki = id_koki;
		this.nama_koki = nama_koki;
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
	public String getStatus_pesanan() {
		return status_pesanan;
	}
	public void setStatus_pesanan(String status_pesanan) {
		this.status_pesanan = status_pesanan;
	}
	public String getWaktu() {
		return waktu;
	}
	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}
	public int getNo_antrian() {
		return no_antrian;
	}
	public void setNo_antrian(int no_antrian) {
		this.no_antrian = no_antrian;
	}
	public String getId_pelayan() {
		return id_pelayan;
	}
	public void setId_pelayan(String id_pelayan) {
		this.id_pelayan = id_pelayan;
	}
	public String getNama_pelayan() {
		return nama_pelayan;
	}
	public void setNama_pelayan(String nama_pelayan) {
		this.nama_pelayan = nama_pelayan;
	}
	public String getId_koki() {
		return id_koki;
	}
	public void setId_koki(String id_koki) {
		this.id_koki = id_koki;
	}
	public String getNama_koki() {
		return nama_koki;
	}
	public void setNama_koki(String nama_koki) {
		this.nama_koki = nama_koki;
	}
}
