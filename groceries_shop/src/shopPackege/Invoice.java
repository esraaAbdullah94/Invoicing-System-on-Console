package shopPackege;

import java.io.IOException;

import java.io.PrintWriter;

import java.io.Serializable;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Scanner;

import java.util.Date;

import java.util.List;

import java.util.ArrayList;

public class Invoice implements Serializable {

	private String customerName;

	private String customerPhone;

	private Date invoiceDate;

	private ArrayList<Item> items;

	private double totalAmount;

	private double paidAmount;

	private double balance;

//4- Report: Statistics (No Of Items, No of Invoices, Total Sales)

	public static void generateReport(List<Invoice> invoices, String fileName) {

		int numberOfInvoices = invoices.size();

		int numberOfItems = 0;

		double totalSales = 0;

		for (Invoice invoice : invoices) {

			numberOfItems += invoice.getItems().size();

			totalSales += invoice.getTotalAmount();

		}

		try {

			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			writer.println("Number of Invoices: " + numberOfInvoices);

			writer.println("Number of Items: " + numberOfItems);

			writer.println("Total Sales: " + totalSales);

			writer.close();

			System.out.println("Report has been saved to " + fileName + " successfully.");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

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