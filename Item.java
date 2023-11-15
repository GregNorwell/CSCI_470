public class Item {
  private String name; //name of product
  private int quantity; //number of products
  private double price; //price of product
  private String upc; //code of product

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
