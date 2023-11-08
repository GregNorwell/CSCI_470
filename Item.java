public class Item {
  private String name;
  private int quantity;
  private double price;
  private String upc;

  Item() {
    
  }
  Item(String name, int qty, double price, String upc) {
    
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
