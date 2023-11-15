public class InventoryTrackerInterface {
  public static void main(String[] args) {
    Inventory inven = new Inventory();
    Item itemy = new Item("crap", 1, 19.99, "qrd");
    inven.addItem(itemy);
    inven.saveInventoryToFile("testout.txt");
    inven.loadInventoryFromFile("test.txt");

  }
}
