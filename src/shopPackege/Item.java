package shopPackege;

public class Item {
	private String itemId;
    private String itemName;
    private double unitPrice;
    private int quantity;
    private double qtyAmount;
    
    // constructor
    public Item(String itemId, String itemName, double unitPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.qtyAmount = unitPrice * quantity; //sets the qty amount/price property as the product of the unit price.
    }

}
