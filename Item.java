public class Item {
  private String name;
  private int quantity;
  private double price;
  private String upc;

  //empty constructor (inaccessable)
  private Item() {
    
  }
  //constructor to create single item object
  Item(String name, int qty, double price, String upc) {
    this.name = name;
    quantity = qty;
    this.price = price;
    this.upc = upc;
  }

  //returns Name
  public String getName() {
    return name;
  }
  //returns Quantity
  public int getQuantity() {
    return quantity;
  }
  //returns Price
  public double getPrice() {
    return price;
  }
  //returns UPC
  public String getUPC() {
    return upc;
  }
}
