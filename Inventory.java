import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Inventory {
  private Item itemArray[] = new Item[100]; //Array of items capped at 100
  private int totalItems = 0; //head index of itemArray[]

  //returns totalItems
  public int getTotalNumberOfItems() {
    return totalItems;
  }

  //returns the item at given index in itemArray[]
  public Item getItem(int index) {
    if (index < 0 || index > totalItems)
      return null;
    return itemArray[index];
  }

  //adds a new item to itemArray into the current inventory
  public void addItem(Item newItem) {
    if (newItem == null){
      System.out.println("Item not added.");
    }
    else {
      itemArray[totalItems] = newItem;
      totalItems++;
    }
    return;
  }

  //saves current inventory to fileName variabes divided by :
  public void saveInventoryToFile(String fileName) {
    try {
      PrintWriter pwr = new PrintWriter(fileName);
      for (int i = 0; i < totalItems; i++)
      {
        pwr.println(itemArray[i].getName() + ":" + itemArray[i].getQuantity() + ":" + itemArray[i].getPrice() + ":" + itemArray[i].getUPC());
      }
      pwr.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  //loads Item inventory separated by colon(:)
  public void loadInventoryFromFile(String fileName) {
    try {
      File fil = new File(fileName);
      Scanner inputFile = new Scanner(fil);

      while (inputFile.hasNext()) { //continue until end of file
        String str = inputFile.nextLine();
        //split string into array divided by :
        String[] splited = str.split(":");
        //use new split array and add item into inven
        Item toAdd = new Item(splited[0], Integer.parseInt(splited[1]), Double.parseDouble(splited[2]), splited[3]);
        addItem(toAdd);
      } 
      inputFile.close(); //close the file
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
