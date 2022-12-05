package model;

public class Menyuplai {
	private BahanBaku bahanbaku;
	private Suplier suplier;
	
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

	public Menyuplai(BahanBaku bahanbaku, Suplier suplier) {
		super();
		this.bahanbaku = bahanbaku;
		this.suplier = suplier;
	}
}
