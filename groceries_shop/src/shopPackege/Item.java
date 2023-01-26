package shopPackege;

import java.io.Serializable;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Scanner;

public class Item implements Serializable {

	private String itemId;

	private String itemName;

	private double unitPrice;

	private int quantity;

	private double qtyAmount;

	private Date expiryDate;
	 

	public Item(String itemId, String itemName, double unitPrice, int quantity, double qtyAmount, Date expiryDate) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.qtyAmount = qtyAmount;
		this.expiryDate = expiryDate;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//public void setUnitPrice(double unitPrice) {
		//this.unitPrice = unitPrice;
	//}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setQtyAmount(double qtyAmount) {
		this.qtyAmount = qtyAmount;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Item() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter item id: ");

		this.itemId = scanner.nextLine();

		System.out.print("Enter item name: ");

		this.itemName = scanner.nextLine();

		System.out.print("Enter unit price: ");

		this.unitPrice = scanner.nextDouble();

		System.out.print("Enter quantity: ");

		this.quantity = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter expiry date (dd-MM-yyyy): ");

		String expiryDateStr = scanner.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {

			this.expiryDate = sdf.parse(expiryDateStr);

		} catch (ParseException e) {

			System.out.println("Invalid date format. Please enter date in the format dd-MM-yyyy.");

		}

		this.qtyAmount = this.unitPrice * this.quantity;

	}

	public String getItemId() {

		return itemId;

	}

	public String getItemName() {

		return itemName;

	}

	public double getUnitPrice() {

		return unitPrice;

	}

	public int getQuantity() {

		return quantity;

	}

	public double getQtyAmount() {

		return qtyAmount;

	}

	public Date getExpiryDate() {

		return expiryDate;

	}

	public void setUnitPrice(double newPrice) {
		this.unitPrice = unitPrice;
		
	}



}
