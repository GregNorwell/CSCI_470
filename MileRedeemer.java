//*************************
//Greg Norwell & Muraad Khan
//CSCI 470
//Assignment 6
//11/30/23
//************************
import java.util.*;

//Main function to help parse and create data to be used later
public class MileRedeemer {
  //ArrayList of MileTicket objects & Remaining redeemable miles variable
  private ArrayList<MileTicket> ticketArray = new ArrayList<MileTicket>();
  private int remainPostRedeem = 0;
  
  public MileTicket[] readDestinations(Scanner fileScanner) {
    //Scan until end of file
    while (fileScanner.hasNext()) {
      //Keep parsing in values as strings
      String str = fileScanner.nextLine();
      //Delimitter
      String[] splited = str.split(";|-");
  
      //Parse up input, save in variables to be passed into the MileTicket object
      String cityName = splited[0];
      int normalPrice = Integer.parseInt(splited[1]);
      int superPrice = Integer.parseInt(splited[2]);
      int addPrice = Integer.parseInt(splited[3]);
      int monthStart = Integer.parseInt(splited[4]);
      int monthEnd = Integer.parseInt(splited[5]);

      //Pass values into MileTicket object
      MileTicket toAdd = new MileTicket(cityName, normalPrice, superPrice, addPrice, monthStart, monthEnd);
      //Add to the ticket array
      ticketArray.add(toAdd);
    }

    //MileTicket ArrayList is converted into an array of objects
    MileTicket[] destinationArray = (MileTicket []) ticketArray.toArray(new MileTicket [ticketArray.size()]);
    //Sort the array
    Arrays.sort(destinationArray, new TicketComparator());
    return destinationArray;
  }

  //Driver function that will help decide what can be redeemed
  public void redeem(int miles, int month, MileTicket[] des) {
    //Applicable destinations
    int results[] = new int[des.length];
    //Remaining miles to be used
    int mileRemain = getRemainingMiles(miles, month, des, results);
    //Print all options
    printTickets(des, results, mileRemain);
  }

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

  //Printing function
  public void printTickets(MileTicket[] sortedDes, int[] results, int remainMiles){
    //Display message to user
    System.out.println("Your accumulated miles can be used to redeem the following tickets:");
    //Loop through the destinations and print possible options with message
    for (int i = 0; i < sortedDes.length; i++){
      if (results[i] == 1)
        System.out.println("*A trip to " + sortedDes[i].getCity() + " economy class");
      if (results[i] == 2)
        System.out.println("*A trip to " + sortedDes[i].getCity() + " first class");
    }
    //Remaining miles get shown to user
    System.out.println("Your remaining miles: " + remainMiles);
  }
}

//Sorts in-descending order by distance
class TicketComparator implements Comparator< MileTicket> { 
  public int compare(MileTicket t1, MileTicket t2) {
    return (t2.getNormalMilesReqEcon() - t1.getNormalMilesReqEcon());
  }
}
