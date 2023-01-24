package shopPackege;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Scanner;

public class Item {

private String itemId;

private String itemName;

private double unitPrice;

private int quantity;

private double qtyAmount;

private Date expiryDate;

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

// Item myItem = new Item();

// System.out.println(myItem.getItemId()); // prints the item id entered by user

// System.out.println(myItem.getItemName()); // prints the item name entered by

// user

// System.out.println(myItem.getUnitPrice()); // prints the unit price

}

