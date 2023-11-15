import java.util.Scanner;  // Import the Scanner class

public class InventoryTrackerInterface {
  public static void main(String[] args) {

    String filename = "test.txt"; //filename for loading and unloading inventory
    
    Scanner sc = new Scanner(System.in);
    Inventory inven = new Inventory();
    int choice;
    do {
      System.out.println("1. Add an item to the inventory");
      System.out.println("2. Get an items info");
      System.out.println("3. Save Inventory to file");
      System.out.println("4. Load Inventory from file");
      System.out.println("5. Exit");
      choice = sc.nextInt();
      sc.nextLine(); //skipping lines so that nextLine functions
      switch(choice) { //switch statement for choice int result from user
        case 1:
          System.out.println("Enter the new items name:");
          String name = sc.nextLine();
          System.out.println("Enter the new items quantity:");
          int quantity = sc.nextInt();
          sc.nextLine();
          System.out.println("Enter the new items price:");
          double price = sc.nextDouble();
          sc.nextLine();
          System.out.println("Enter the new items upc:");
          String upc = sc.nextLine();
          Item itemy = new Item(name, quantity, price, upc); // create new Item using the given attributes
          inven.addItem(itemy);// add the item to the current inventory
          break;
        case 2:
          System.out.println("Which item would you like info for? [0-" + (inven.getTotalNumberOfItems() - 1) + "]");
          int choice2 = sc.nextInt();
          System.out.println("Name:      " + inven.getItem(choice2).getName());
          System.out.println("Quantity:  " + inven.getItem(choice2).getQuantity());
          System.out.println("Price:     " + inven.getItem(choice2).getPrice());
          System.out.println("UPC:       " + inven.getItem(choice2).getUPC());
          break;
        case 3:
          inven.saveInventoryToFile(filename);
          System.out.println("Inventory Saved!");
          break;
        case 4:
          inven.loadInventoryFromFile(filename);
          System.out.println("Inventory Loaded!");
          break;
        case 5:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice input");
      }
    } while (choice != 5);

  }
}
