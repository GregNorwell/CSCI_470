public class InventoryTrackerInterface {
  public static void main(String[] args) {
    Inventory inven = new Inventory();
    Item itemy = new Item("crap", 1, 19.99, "qrd");
    inven.addItem(itemy);
    inven.saveInventoryToFile("test.txt");
    inven.loadInventoryFromFile("test.txt");

    for (int i = 0; i < inven.getTotalNumberOfItems(); i++) {
      System.out.println(itemArray[i].getName() + " " + itemArray[i].getQuantity() + " " + itemArray[i].getPrice() + " " + itemArray[i].getUPC());
    }

  }
}
