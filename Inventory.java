import java.io.PrintWriter;

public class Inventory {
  private Item itemArray[];
  private int totalItems = 0;

  public int getTotalNumberOfItems() {
    return totalItems;
  }
  public Item getItem(int index) {
    if (index < 0 || index > totalItems)
      return null;
    return itemArray[index];
  }
  public void addItem(Item newItem) {
    if (newItem == null){
      System.out.println("Item not added.");
    }
    else {
      itemArray[totalItems] = newItem(newItem);
      totalItems++;
    }
    return;
  }
  public void saveInventoryToFile(String fileName) {
  }
  public void loadInventoryFromFile(String fileName) {
  }
}
