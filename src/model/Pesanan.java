package model;

public class Pesanan {
	private char id_pesanan;
	private String status_pesanan;
	private int waktu;
	private char id_pelanggan;
	private int no_antrian;
	
	public Pesanan(char id_pesanan, String status_pesanan, int waktu, char id_pelanggan, int no_antrian) {
		super();
		this.id_pesanan = id_pesanan;
		this.status_pesanan = status_pesanan;
		this.waktu = waktu;
		this.id_pelanggan = id_pelanggan;
		this.no_antrian = no_antrian;
	}

	public char getId_pesanan() {
		return id_pesanan;
	}

	public void setId_pesanan(char id_pesanan) {
		this.id_pesanan = id_pesanan;
	}

	public String getStatus_pesanan() {
		return status_pesanan;
	}

	public void setStatus_pesanan(String status_pesanan) {
		this.status_pesanan = status_pesanan;
	}

	public int getWaktu() {
		return waktu;
	}

	public void setWaktu(int waktu) {
		this.waktu = waktu;
	}

	public char getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(char id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public int getNo_antrian() {
		return no_antrian;
	}

	public void setNo_antrian(int no_antrian) {
		this.no_antrian = no_antrian;
	}
}
