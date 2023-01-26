package shopPackege;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageShopItems implements Serializable {
	static ArrayList<Item> itemsList = new ArrayList<Item>();
	public static ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	static Scanner scanner = new Scanner(System.in);

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

	// 3. Change Item Price
	public static void changeItemPrice() {
		System.out.print("Enter item id to change price: ");
		scanner.nextLine();
		String itemId = scanner.nextLine();
		boolean itemFound = false;
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemId().equals(itemId)) {
				System.out.print("Enter new price: ");
				double newPrice = scanner.nextDouble();
				scanner.nextLine(); // to consume the newline character
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

	// Menu for mange shop Item
	public static void displayMenu() {
		int option;
		do {
			System.out.println("Manage Shop Items");
			System.out.println("1. Add Items");
			System.out.println("2. Delete Items");
			System.out.println("3. Change Item Price");
			System.out.println("4. Report All Items");
			System.out.println("5. Go Back");
			System.out.print("Enter option: ");
			option = scanner.nextInt();
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
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid option. Please enter a valid option.");
				break;
			}
		} while (option != 5);
	}

}
