package dao;

import java.util.List;

import model.Invoice;

public interface InvoiceDAO {
	public void addInvoice(Invoice i);

	public List<Invoice> getList();
	
	public int getLastId();
}
