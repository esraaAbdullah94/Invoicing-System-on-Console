package shopPackege;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import java.util.Date;

import java.util.ArrayList;

public class Invoice implements Serializable {

	public Invoice(String customerName, String customerPhone, Date invoiceDate, ArrayList<Item> items,
			double totalAmount, double paidAmount, double balance) {
		
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.invoiceDate = invoiceDate;
		this.items = items;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.balance = balance;
	}

	private String customerName;

	private String customerPhone;

	private Date invoiceDate;

	private ArrayList<Item> items;

	private double totalAmount;

	private double paidAmount;

	private double balance;

	public Invoice() {

		this.items = new ArrayList<>();

		this.totalAmount = 0;

		this.paidAmount = 0;

		this.balance = 0;

		setCustomerName();

		setCustomerPhone();

		setInvoiceDate();

	}

	public void setCustomerName() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the customer name: ");

		this.customerName = scanner.nextLine();

	}

	public void setCustomerPhone() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the customer phone number: ");

		this.customerPhone = sc.nextLine();

	}

	public void setInvoiceDate() {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.print("Enter the invoice date (yyyy-MM-dd): ");

		String dateInput = sc.nextLine();

		try {

			this.invoiceDate = dateFormat.parse(dateInput);

		} catch (ParseException e) {

			System.out.println("Invalid date format, please enter the date in yyyy-MM-dd format.");

			setInvoiceDate();

		}

	}

	public void addItem(Item item) {

		items.add(item);

		totalAmount += item.getQtyAmount();

	}

	public void setPaidAmount(double paidAmount) {

		this.paidAmount = paidAmount;

		balance = totalAmount - paidAmount;

	}

	public String getCustomerName() {

		return customerName;

	}

	public String getCustomerPhone() {

		return customerPhone;

	}

	public Date getInvoiceDate() {

		return invoiceDate;

	}

	public ArrayList<Item> getItems() {

		return items;

	}

	public double getTotalAmount() {

		return totalAmount;

	}

	public double getPaidAmount() {

		return paidAmount;

	}

	public double getBalance() {

		return balance;

	}

}