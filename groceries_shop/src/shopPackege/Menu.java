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
	public static void goBackToMainMenu() {
	    System.out.println("Returning to Application Main Menu...");
	    
	}

	public void show() {

		while (true) {

			System.out.println("Application Main Menu: ");

			System.out.println("**Shop Settings**");

			System.out.println("1. Load Data (Items and invoices)");

			System.out.println("2. Set Shop Name (data should be saved)");

			System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)");

			System.out.println("4. Go Back");

			System.out.println("*******************"

					+ "*****************");

			String option = scanner.nextLine();

			switch (option) {

			case "1":

				menuOptions.get("1. Load Data (Items and invoices)").run();

				break;

			case "2":

				menuOptions.get("2. Set Shop Name (data should be saved)").run();

				break;

			case "3":

				menuOptions.get("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)").run();

				break;

			case "4":
				goBackToMainMenu();

				break;

			default:

				System.out.println("Invalid option. Please try again.");

			}

			if (option.equals("5")) {

				break;

			}

		}

	}

	public double getBalance() {

		return getBalance();

	}

}