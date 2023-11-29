import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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
      ticketArray.add(toAdd);
    }
    MileTicket [] destinationArray = (MileTicket []) ticketArray.toArray(new MileTicket [ticketArray.size()]);
    Arrays.sort(destinationArray, TicketComparator());
    return destinationArray[];
  }

  //miles is the total available miles for redeeming, month is the 
  //desired month of departure, and des is an array of MileTicket objects. To avoid writing one 
  //huge method, you can (and probably should) have the redeem() method call some other 
  //methods to accomplish subtasks as part of the larger overall algorithm
  public void redeem(int miles, int month, MileTicket[] des) {
    
  }

  //miles is the total available miles for redeeming, 
  //month is the desired month of departure, des is an array of MileTicket objects, and 
  //results is an array in which each int value indicates the redeeming result for each 
  //destination (i.e., 1 indicates an economy class ticket, and 2 indicates a first class ticket).
  //Moreover, this method will return the remaining miles after redeeming.
  public int getRemainingMiles (int miles, int month, MileTicket[] des, int[] results) {
    ArrayList<int> temp = new ArrayList<int>(); //holds order of whether or not a economy ticket to the destination was obtained
    for (int i = 0; i < des.length; i++) { //roll through all MileTicket[] objects in destinations ordered from farthest to closest
      bool supSave = false;
      for (int j = des[i].getSSMonthStart(); j <= des[i].getSSMonthEnd(); i++) { //roll through SuperSaver months beginning to end, YEAR ROLLOVER (ex. 12-1) WILL BREAK THIS
        if (j == month) { //if month is applicable for SuperSaver at destination
          supSave = true;
        }
      }
      
      if ((miles - des[i].getNormalMilesReqEcon()) >= 0 || ((miles - des[i].getSuperMilesReqEcon()) >= 0 && supSave == true)) { //if the current destination (farthest to closest) is affordable
        if (supSave == true)
          miles = miles - des[i].getSuperMilesReqEcon();
        else
          miles = miles - des[i].getNormalMilesReqEcon();
        temp.add(1); //register as economy class ticket
      } else {
        temp.add(0); //resgister as no ticket
      }
    }

    int y = 0; ////used to trace temp but only count up on selected destinations
    for (int i = 0; i < temp.size(); i++) { //loop through temp which is filled with 1's and 0's of whether or not a destination was selected
      if (temp.get(i) == 1) { //if the destination was selected
        if ((miles - des[i].getAddMilesReqFirst()) >= 0) { //if the first class extention is affordable
          miles = miles - des[i].getAddMilesReqFirst();
          results[y] = 2; //two marks a first class ticket
        } else {
          results[y] = 1; //one marks an economy class ticket
        }
        y++;
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
      else
        System.out.println("*A trip to " + sortedDes[i].getCity() + " first class");
    }
    System.out.println("Your remaining miles: " + remainMiles);
  }

}

class TicketComparator implements Comparator<MileTicket> { 
  public int compare(MileTicket t1, MileTicket t2) {
    return (t2.getNormalMilesReqEcon() - t1.getNormalMilesReqEcon());
  }
}
