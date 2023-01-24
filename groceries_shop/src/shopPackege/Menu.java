package shopPackege;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	private HashMap<String, Runnable> menuOptions;
	private Scanner scanner;

	public Menu() {
		menuOptions = new HashMap<>();
		scanner = new Scanner(System.in);
	}

	public void addOption(String option, Runnable action) {
		menuOptions.put(option, action);
	}

	public void show() {
		while (true) {
			System.out.println("Main Menu:");
			System.out.println("1-Shop Settings");
			System.out.println("1. Load Data (Items and invoices)");
			System.out.println("2. Set Shop Name (data should be saved)");
			System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)");
			System.out.println("4. Go Back");

			String option = scanner.nextLine();

			switch (option) {
			case "1. Load Data (Items and invoices)":
				menuOptions.get("1. Load Data (Items and invoices)").run();
				break;
			case "2. Set Shop Name (data should be saved)":
				menuOptions.get("2. Set Shop Name (data should be saved)").run();
				break;
			case "3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)":
				menuOptions.get("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)").run();
				break;
			case "4":
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
			if (option.equals("4")) {
				break;
			}
		}
	}

}
