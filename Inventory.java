import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Inventory {
  private Item itemArray[] = new Item[100];
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
      itemArray[totalItems] = newItem;
      System.out.println(itemArray[totalItems].getName() + " : " + itemArray[totalItems].getQuantity() + " : " + itemArray[totalItems].getPrice() + " : " + itemArray[totalItems].getUPC());
      totalItems++;
    }
    return;
  }
  public void saveInventoryToFile(String fileName) {
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < totalItems; i++)
    {
      System.out.println(itemArray[i].getName() + " : " + itemArray[i].getQuantity() + " : " + itemArray[i].getPrice() + " : " + itemArray[i].getUPC());
    }
  }
  public void loadInventoryFromFile(String fileName) {
  }
}
