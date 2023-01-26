package shopPackege;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private static String shopName;

	private static String tel;

	private static String fax;

	private static String email;

	private static String website;

	private static Scanner scanner = new Scanner(System.in);

// Load Data Method

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

// 2. Set Shop Name (data should be saved)

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

/// 3- Set Invoice Header (Tel/Fax/Email/Website)(Data should be saved)

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

	public static void show(String menuType) {

		switch (menuType) {

		case "main":

			showMainMenu();

			break;

		case "settings":

			showShopSettingsMenu();

			break;

		case "items":

			//showManageShopItemsMenu();

			break;

		default:

			System.out.println("Invalid menu type.");

		}

	}

	private static void showMainMenu() {

		int userChoice;

		do {

			System.out.println("Application Main Menu:");

			System.out.println("1- Shop Settings");

			System.out.println("2- Manage Shop Items");

			System.out.println("Enter your choice: ");

			userChoice = scanner.nextInt();

			switch (userChoice) {

			case 1:

				show("settings");

				break;

			case 2:

				show("items");

				break;

			default:

				System.out.println("Invalid choice, please try again.");

			}

		} while (userChoice != 0);

	}

	private static void showShopSettingsMenu() {

		int userChoice;

		do {

			System.out.println("1. Load Data (Items and invoices)");

			System.out.println("2. Set Shop Name (data should be saved)");

			System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)");

			System.out.println("4. Go Back");

			System.out.println("Enter your choice: ");

			userChoice = scanner.nextInt();

			switch (userChoice) {

			case 1:

				loadData();

				break;

			case 2:

				setShopName();

				break;

			case 3:

				setInvoiceHeader();

				break;

			case 4:

				break;

			default:

				System.out.println("Invalid choice, please try again.");

			}

		} while (userChoice != 4);

	}

	/*
	 * private static void showManageShopItemsMenu() {
	 * 
	 * int userChoice;
	 * 
	 * do {
	 * 
	 * System.out.println("1. Add Items (Item should be saved/serialized)");
	 * 
	 * System.out.println("2. Delete Items");
	 * 
	 * System.out.println("3. Change Item Price");
	 * 
	 * System.out.println("4. Report All Items");
	 * 
	 * System.out.println("5. Go Back");
	 * 
	 * System.out.println("Enter your choice: ");
	 * 
	 * userChoice = scanner.nextInt();
	 * 
	 * switch (userChoice) {
	 * 
	 * case 1:
	 * 
	 * addItems();
	 * 
	 * break;
	 * 
	 * case 2:
	 * 
	 * deleteItem();
	 * 
	 * break;
	 * 
	 * case 3:
	 * 
	 * changeItemPrice();
	 * 
	 * break;
	 * 
	 * case 4:
	 * 
	 * reportAllItems();
	 * 
	 * break; case 5: createNewInvoice(); break;
	 * 
	 * case 6:
	 * 
	 * break;
	 * 
	 * default:
	 * 
	 * System.out.println("Invalid choice, please try again.");
	 * 
	 * }
	 * 
	 * } while (userChoice != 5);
	 * 
	 * }
	 */

}
