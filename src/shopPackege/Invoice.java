package shopPackege;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	// private properties
	private String customerName;
	private String customerPhone;
	private Date invoiceDate;
	private ArrayList<Item> items;
	private double totalAmount;
	private double paidAmount;
	private double balance;

	// a constructor that takes in previous properties
	public Invoice(String customerName, String customerPhone) {
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.invoiceDate = new Date();
		this.items = new ArrayList<Item>();
		this.totalAmount = 0;
		this.paidAmount = 0;
		this.balance = 0;
	}

}
