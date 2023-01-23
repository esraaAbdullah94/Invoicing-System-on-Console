package shopPackege;

import java.util.Date;

public class Invoice {
	// private properties
	private String customerFullName;
	private String phoneNumber;
	private Date invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;

	// a constructor that takes in previous properties
	public Invoice(String customerFullName, String phoneNumber, Date invoiceDate, int numberOfItems, double totalAmount,
			double paidAmount) {
		this.customerFullName = customerFullName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = invoiceDate;
		this.numberOfItems = numberOfItems;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.balance = totalAmount - paidAmount; // difference between the total amount and paid amount
	}

}
