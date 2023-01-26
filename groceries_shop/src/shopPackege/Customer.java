package shopPackege;

import java.util.Scanner;

public class Customer {

	private String customerId;

	private String customerName;

	private String customerAddress;

	private String customerPhone;

	public Customer() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer id: ");

		this.customerId = scanner.nextLine();

		System.out.print("Enter customer name: ");

		this.customerName = scanner.nextLine();

		System.out.print("Enter customer address: ");

		this.customerAddress = scanner.nextLine();

		System.out.print("Enter customer phone: ");

		this.customerPhone = scanner.nextLine();

	}

	public String getCustomerId() {

		return customerId;

	}

	public String getCustomerName() {

		return customerName;

	}

	public String getCustomerAddress() {

		return customerAddress;

	}

	public String getCustomerPhone() {

		return customerPhone;

	}

}
