public class InventoryTrackerInterface {
  public static void main(String[] args) {
    Inventory inven = new Inventory();
    Item itemy = new Item("crap", 1, 19.99, "qrd");
    System.out.println(inven.getTotalNumberOfItems());
    inven.addItem(itemy);
    System.out.println(inven.getTotalNumberOfItems());
    inven.saveInventoryToFile("test.txt");
  }
}
