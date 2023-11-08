public class Item {
  String name;
  int quantity;
  double price;
  String upc;

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
