import java.util.*;

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

    //Parse up input, save in variables to be passed into the MileTicket object
    String cityName = splited[0];
    int normalPrice = Integer.parseInt(splited[1]);
    int superPrice = Integer.parseInt(splited[2]);
    int addPrice = Integer.parseInt(splited[3]);
    int monthStart = Integer.parseInt(splited[4]);
    int monthEnd = Integer.parseInt(splited[5]);
  
    MileTicket toAdd = new MileTicket(cityName, normalPrice, superPrice, addPrice, monthStart, monthEnd);
    ticketArray.add(toAdd);
  }
  MileTicket[] destinationArray = (MileTicket []) ticketArray.toArray(new MileTicket [ticketArray.size()]);

  Arrays.sort(destinationArray, new TicketComparator());

  return destinationArray;
}

  //miles is the total available miles for redeeming, month is the 
  //desired month of departure, and des is an array of MileTicket objects. To avoid writing one 
  //huge method, you can (and probably should) have the redeem() method call some other 
  //methods to accomplish subtasks as part of the larger overall algorithm
  public void redeem(int miles, int month, MileTicket[] des) {
    int results[] = new int[des.length];
    int mileRemain = getRemainingMiles(miles, month, des, results);
    printTickets(des, results, mileRemain);
  }

  //miles is the total available miles for redeeming, 
  //month is the desired month of departure, des is an array of MileTicket objects, and 
  //results is an array in which each int value indicates the redeeming result for each 
  //destination (i.e., 1 indicates an economy class ticket, and 2 indicates a first class ticket).
  //Moreover, this method will return the remaining miles after redeeming.
  public int getRemainingMiles (int miles, int month, MileTicket[] des, int[] results) {
    for (int i = 0; i < des.length; i++) { //roll through all MileTicket[] objects in destinations ordered from farthest to closest
      boolean supSave = false;
      for (int j = des[i].getSSMonthStart(); j <= des[i].getSSMonthEnd(); j++) { //roll through SuperSaver months beginning to end, YEAR ROLLOVER (ex. 12-1) WILL BREAK THIS
        if (j == month) { //if month is applicable for SuperSaver at destination
          supSave = true;
        }
      }
      
      if ((miles - des[i].getNormalMilesReqEcon()) >= 0 || ((miles - des[i].getSuperMilesReqEcon()) >= 0 && supSave == true)) { //if the current destination (farthest to closest) is affordable
        if (supSave == true)
          miles = miles - des[i].getSuperMilesReqEcon();
        else
          miles = miles - des[i].getNormalMilesReqEcon();
        results[i] = 1; //register as economy class ticket
      } else {
        results[i] = 0; //resgister as no ticket
      }
    }

    for (int i = 0; i < results.length; i++) { //loop through results which is filled with 1's and 0's of whether or not a destination was selected
      if (results[i] == 1) { //if the destination was selected
        if ((miles - des[i].getAddMilesReqFirst()) >= 0) { //if the first class extention is affordable
          miles = miles - des[i].getAddMilesReqFirst();
          results[i] = 2; //two marks a first class ticket
        }
      }
    }
    return miles;
  }

  //will be responsible for printing out the ticket’s
  //information for redeeming. sortedDes is an array of MileTicket objects, and 
  //remainMiles is the information about the remaining miles after redeeming. Similar to that in 
  //the method getRemainingMiles(), results is an int array, in which each int value
  //indicates the redeeming result for each destination
  public void printTickets(MileTicket[] sortedDes, int[] results, int remainMiles) {
    System.out.println("Your accumulated miles can be used to redeem the following tickets:");
    for (int i = 0; i < sortedDes.length; i++){
      if (results[i] == 1)
        System.out.println("*A trip to " + sortedDes[i].getCity() + " economy class");
      if (results[i] == 2)
        System.out.println("*A trip to " + sortedDes[i].getCity() + " first class");
    }
    System.out.println("Your remaining miles: " + remainMiles);
  }

}

class TicketComparator implements Comparator< MileTicket> { 
  public int compare(MileTicket t1, MileTicket t2) {
    return (t2.getNormalMilesReqEcon() - t1.getNormalMilesReqEcon());
  }
}
