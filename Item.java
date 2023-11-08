public class Item {
  private String name;
  private int quantity;
  private double price;
  private String upc;

  private Item() {
    
  }
  Item(String name, int qty, double price, String upc) {
    this.name = name;
    quantity = qty;
    this.price = price;
    this.upc = upc;
  }

  public String getName() {
    return name;
  }
  public int getQuantity() {
    return quantity;
  }
  public double getPrice() {
    return price;
  }
  public String getUPC() {
    return upc;
  }
}
