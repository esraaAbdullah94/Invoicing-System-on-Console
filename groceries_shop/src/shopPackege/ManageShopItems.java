package shopPackege;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ManageShopItems implements Serializable {
	static ArrayList<Item> itemsList = new ArrayList<Item>();
	public static ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	static Scanner scanner = new Scanner(System.in);
	static int[] optionCount = new int[9];

	// 1. Add Items (Item should be saved/serialized)
	public static void addItems() {
		Item item = new Item();
		itemsList.add(item);
		System.out.println("Item added successfully!");
		try (FileOutputStream fos = new FileOutputStream("GroceriesShop.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(itemsList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 2. Delete Items
	public static void deleteItems() {
		System.out.print("Enter item id to delete: ");
		scanner.nextLine(); // flush the buffer
		String itemId = scanner.nextLine();
		boolean itemFound = false;
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemId().equals(itemId)) {
				itemsList.remove(i);
				itemFound = true;
				System.out.println("Item deleted successfully!");
				break;
			}
		}
		if (!itemFound) {
			System.out.println("Item not found. Please enter a valid item id.");
		}
	}

	public static void changeItemPrice() {
		System.out.print("Enter item id to change price: ");
		String itemId = scanner.nextLine();
		boolean itemFound = false;
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemId().equals(itemId)) {
				System.out.print("Enter new price: ");
				double newPrice = scanner.nextDouble();
				scanner.nextLine();
				itemsList.get(i).setUnitPrice(newPrice);
				itemFound = true;
				System.out.println("Item price changed successfully!");
				break;
			}
		}
		if (!itemFound) {
			System.out.println("Item not found. Please enter a valid item id.");
		}
	}

	// 4. Report All Items
	public static void reportAllItems() {
		if (itemsList.isEmpty()) {
			System.out.println("No items to report.");
		} else {
			for (Item item : itemsList) {
				System.out.println(item.toString());
			}
		}
	}

	// Create New Invoice (Invoices should be save/serialized)
	public static void createNewInvoice() {
		Invoice invoice = new Invoice();
		invoicesList.add(invoice);
		System.out.println("Invoice created successfully!");
		try (FileOutputStream fos = new FileOutputStream("Invoices.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(invoicesList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 4- Report: Statistics (No Of Items, No of Invoices, Total Sales)
	public static void reportStatistics() {
		int noOfItems = itemsList.size();
		int noOfInvoices = invoicesList.size();
		double totalSales = 0;
		for (Invoice invoice : invoicesList) {
			totalSales += invoice.getTotalAmount();
		}
		System.out.println("No of items: " + noOfItems);
		System.out.println("No of invoices: " + noOfInvoices);
		System.out.println("Total sales: " + totalSales);
	}

	// Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items,
	// Total, Balance)
	public static void reportAllInvoices() {
		if (invoicesList.isEmpty()) {
			System.out.println("No invoices to report.");
		} else {
			for (Invoice invoice : invoicesList) {
				System.out.println(invoice.toString());
			}
		}
	}

	// Search (1) Invoice (Search by Invoice No and Report All Invoice details with
	// items)
	public static void searchInvoice() {
		System.out.print("Enter invoice number to search: ");
		scanner.nextLine(); // flush the buffer
		String invoiceNo = scanner.nextLine();
		boolean invoiceFound = false;
		for (Invoice invoice : invoicesList) {
			if (invoice.getInvoiceNo().equals(invoiceNo)) {
				System.out.println(invoice.toString());
				invoiceFound = true;
				break;
			}
		}
		if (!invoiceFound) {
			System.out.println("Invoice not found. Please enter a valid invoice number.");
		}
	}
	
	// 8- Exit (Are you sure you want to exit? If yes, program ends, if No , then
	// main menu reprinted again)

	// Menu for mange shop Item
	public static void displayMenu() {
		int option;
		do {
			System.out.println("Manage Shop Items");
			System.out.println("1. Add Items");
			System.out.println("2. Delete Items");
			System.out.println("3. Change Item Price");
			System.out.println("4. Report All Items");
			System.out.println("5. Create New Invoice");
			System.out.println("6. Report: Statistics");
			System.out.println("7. Report: All Invoices");
			System.out.println("8. Search Invoice");
			System.out.println("9. Exit");

			System.out.print("Enter option: ");
			option = scanner.nextInt();
            optionCount[option - 1]++;
			switch (option) {
			case 1:
				addItems();
				break;
			case 2:
				deleteItems();
				break;
			case 3:
				changeItemPrice();
				break;
			case 4:
				reportAllItems();
				break;
			case 5:
				createNewInvoice();
				break;
			case 6:
				reportStatistics();
	            break;
	        case 7:
	            reportAllInvoices();
	            break;
	        case 8:
	            searchInvoice();
	            break;
	        case 9:
	        	System.out.println("Are you sure you want to exit? Press y/n");
                char c = scanner.next().charAt(0);
                if (c == 'y') {
                    System.out.println("Exiting program...");
                    break;
                } else {
                    System.out.println("Continuing program...");
                    break;
                }
            default:
                System.out.println("Invalid option. Please enter a valid option.");
                break;
        }
    } while (option != 9);
		// Print each Main Menu Item with the number of times it was selected
        for (int i = 0; i < optionCount.length; i++) {
            System.out.println((i + 1) + ". " + optionCount[i] + " times selected.");
	}

	}
}
