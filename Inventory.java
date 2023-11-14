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
    try {
      PrintWriter pwr = new PrintWriter(fileName);
      for (int i = 0; i < totalItems; i++)
      {
        pwr.println(itemArray[i].getName() + " : " + itemArray[i].getQuantity() + " : " + itemArray[i].getPrice() + " : " + itemArray[i].getUPC());
      }
      pwr.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  public void loadInventoryFromFile(String fileName) {
    try {
      File fil = new File(fileName);
      Scanner inputFile = new Scanner(fil);

      while (inputFile.hasNext()) {
        String str = inputFile.nextLine();
      }
      
      inputFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
