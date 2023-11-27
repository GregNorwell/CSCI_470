import java.util.Scanner;

public class MileRedeemer {
  private ArrayList<MileTicket> ticketArray = new ArrayList<MileTicket>();
  private int remainPostRedeem = 0;
  
  //use a Scanner object as the input parameter 
  //for flexibility and reusability. This method should use the Scanner object to read and parse 
  //the destination data into an array of MileTicket objects, which should then be sorted by their 
  //normal mileage
  public MileTicket[] readDestinations(Scanner fileScanner) {
    int i = 0;
    while (fileScanner.hasNext()) {
      String str = fileScanner.nextLine();
      String[] splited = str.split(";|-");
      
      //Create splited variables here
      //Replace variables as parameters in MileTicket instance below
      
      MileTicket toAdd = new MileTicket(splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]));
      ticketArray[i] = toAdd;
      i++;
    }
    return ticketArray[];
  }

  //miles is the total available miles for redeeming, month is the 
  //desired month of departure, and des is an array of MileTicket objects. To avoid writing one 
  //huge method, you can (and probably should) have the redeem() method call some other 
  //methods to accomplish subtasks as part of the larger overall algorithm
  public void redeem(int miles, int month, mileTicket[] des) {
    //Double check mileTicket spelling
  }

  //miles is the total available miles for redeeming, 
  //month is the desired month of departure, des is an array of MileTicket objects, and 
  //results is an array in which each int value indicates the redeeming result for each 
  //destination (i.e., 1 indicates an economy class ticket, and 2 indicates a first class ticket).
  //Moreover, this method will return the remaining miles after redeeming.
  public int getRemainingMiles (int miles, int month, MileTicket[] des, int[] results) {
    
  }

  //will be responsible for printing out the ticket’s
  //information for redeeming. sortedDes is an array of MileTicket objects, and 
  //remainMiles is the information about the remaining miles after redeeming. Similar to that in 
  //the method getRemainingMiles(), results is an int array, in which each int value
  //indicates the redeeming result for each destination
  public void printTickets(MileTicket[] sortedDes, int[] results, int remainMiles) {
    
  }
}
