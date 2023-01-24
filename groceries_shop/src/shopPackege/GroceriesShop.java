package shopPackege;

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Scanner;

public class GroceriesShop {

	private static String shopName;

	private static String tel;

	private static String fax;

	private static String email;

	private static String website;

	public static void loadData() {

// Create an Invoice object with user input

		Invoice invoice = new Invoice();

// Add items to the invoice

		while (true) {

			Item item = new Item();

			invoice.addItem(item);

			System.out.print("Do you want to add more items? (y/n): ");

			String choice = new Scanner(System.in).nextLine();

			if (!choice.equalsIgnoreCase("y")) {

				break;

			}

		}

		try (FileWriter fileWriter = new FileWriter("GroceriesShop.txt");

				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

// Write the invoice data to the file

			bufferedWriter.write("Invoice Date: " + invoice.getInvoiceDate());

			bufferedWriter.newLine();

			bufferedWriter.write("Customer Name: " + invoice.getCustomerName());

			bufferedWriter.newLine();

			bufferedWriter.write("Customer Phone: " + invoice.getCustomerPhone());

			bufferedWriter.newLine();

			bufferedWriter.write("Total Amount: " + invoice.getTotalAmount());

			bufferedWriter.newLine();

			bufferedWriter.write("Paid Amount: " + invoice.getPaidAmount());

			bufferedWriter.newLine();

			bufferedWriter.write("Balance: " + invoice.getBalance());

			bufferedWriter.newLine();

// Write the item data to the file

			for (Item item : invoice.getItems()) {

				bufferedWriter.write("Item ID: " + item.getItemId());

				bufferedWriter.newLine();

				bufferedWriter.write("Item Name: " + item.getItemName());

				bufferedWriter.newLine();

				bufferedWriter.write("Unit Price: " + item.getUnitPrice());

				bufferedWriter.newLine();

				bufferedWriter.write("Quantity: " + item.getQuantity());

				bufferedWriter.newLine();

				bufferedWriter.write("Expiry Date: " + item.getExpiryDate());

				bufferedWriter.newLine();

			}

			System.out.println("Data saved to GroceriesShop.txt");

		} catch (IOException e) {

			System.out.println("An error occurred while saving the data to GroceriesShop.txt");

		}

	}
	//2. Set Shop Name (data should be saved)

	public static void setShopName() {

	    System.out.print("Enter the shop name: ");
	    shopName = new Scanner(System.in).nextLine();

	    try (FileWriter fileWriter = new FileWriter("GroceriesShop.txt", true);
	         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
	        bufferedWriter.write("Shop Name: " + shopName);
	        bufferedWriter.newLine();
	        System.out.println("Shop name set to: " + shopName);
	    } catch (IOException e) {
	        System.out.println("An error occurred while saving the shop name to GroceriesShop.txt");
	    }
	}


	public static void setInvoiceHeader() {

		System.out.print("Enter the Tel: ");

		tel = new Scanner(System.in).nextLine();

		System.out.print("Enter the Fax: ");

		fax = new Scanner(System.in).nextLine();

		System.out.print("Enter the Email: ");

		email = new Scanner(System.in).nextLine();

		System.out.print("Enter the Website: ");

		website = new Scanner(System.in).nextLine();

// Code to save the invoice header information to a file or database goes here

		System.out.println("Invoice header set:");

		System.out.println("Tel: " + tel);

		System.out.println("Fax: " + fax);

		System.out.println("Email: " + email);

		System.out.println("Website: " + website);

	}

	public static void main(String[] args) {

//Invoice invoice = new Invoice();

//invoice.addItem(new Item());

//invoice.addItem(new Item());

//invoice.setPaidAmount(100);

//invoice.saveInvoice();

		Menu menu = new Menu();

		menu.addOption("1. Load Data (Items and invoices)", GroceriesShop::loadData);

		menu.addOption("2. Set Shop Name (data should be saved)", GroceriesShop::setShopName);

		menu.addOption("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)",
				GroceriesShop::setInvoiceHeader);

		menu.show();

	}

}