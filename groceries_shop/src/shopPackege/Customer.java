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
    //Customer myCustomer = new Customer();
//System.out.println(myCustomer.getCustomerId()); // prints the customer id entered by user
    //System.out.println(myCustomer.getCustomerName()); // prints the customer name entered by user
    //System.out.println(myCustomer.getCustomerAddress()); // prints the customer address entered by user
   // System.out.println(myCustomer.getCustomerPhone()); // prints the customer phone entered by user

}

