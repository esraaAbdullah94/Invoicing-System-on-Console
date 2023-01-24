package shopPackege;

import java.util.Scanner;

public class GroceriesShop {
	private static String shopName;
    private static String tel;
    private static String fax;
    private static String email;
    private static String website;

    public static void loadData() {
        // Code to load data from a file or database goes here
        System.out.println("Loading Data...");
    }

    public static void setShopName() {
        System.out.print("Enter the shop name: ");
        shopName = new Scanner(System.in).nextLine();
        // Code to save the shop name to a file or database goes here
        System.out.println("Shop name set to: " + shopName);
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
}


