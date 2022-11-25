package model;

import java.sql.Timestamp;

public class Pesanan {
	private String id_pesanan;
	private String status_pesanan;
	private Timestamp waktu;
	private String id_pelanggan;
	private int no_antrian;
	
	public Pesanan(String id_pesanan, String status_pesanan, Timestamp waktu, String id_pelanggan, int no_antrian) {
		super();
		this.id_pesanan = id_pesanan;
		this.status_pesanan = status_pesanan;
		this.waktu = waktu;
		this.id_pelanggan = id_pelanggan;
		this.no_antrian = no_antrian;
	}

	public String getId_pesanan() {
		return id_pesanan;
	}

	public void setId_pesanan(String id_pesanan) {
		this.id_pesanan = id_pesanan;
	}

	public String getStatus_pesanan() {
		return status_pesanan;
	}

	public void setStatus_pesanan(String status_pesanan) {
		this.status_pesanan = status_pesanan;
	}

	public Timestamp getWaktu() {
		return waktu;
	}

	public void setWaktu(Timestamp waktu) {
		this.waktu = waktu;
	}

	public String getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public int getNo_antrian() {
		return no_antrian;
	}

	public void setNo_antrian(int no_antrian) {
		this.no_antrian = no_antrian;
	}
}
