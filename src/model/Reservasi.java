package model;

public class Reservasi {
	private String id_reservasi;
	private String waktu;
	private String id_pesanan;
	
	public Reservasi(String id_reservasi, String waktu, String id_pesanan) {
		super();
		this.id_reservasi = id_reservasi;
		this.waktu = waktu;
		this.id_pesanan = id_pesanan;
	}

	public Reservasi() {
		// TODO Auto-generated constructor stub
	}

	public String getId_reservasi() {
		return id_reservasi;
	}

	public void setId_reservasi(String id_reservasi) {
		this.id_reservasi = id_reservasi;
	}

	public String getWaktu() {
		return waktu;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}

	public String getId_pesanan() {
		return id_pesanan;
	}

	public void setId_pesanan(String id_pesanan) {
		this.id_pesanan = id_pesanan;
	}
}
