//*************************
//Greg Norwell & Muraad Khan
//CSCI 470
//Assignment 6
//11/30/23
//************************
import java.io.*;
import java.util.*;

public class MainClass {
  public static void main(String[] args) {
    //Create scanner variable to read in
    char cont = 'n';
    Scanner cons = new Scanner(System.in);

    //Check to prevent user from inputting invalid value
    if(args.length != 1) {
      System.out.println("Command line arg filename error");
      //Close scanner
      cons.close();
      return;
    }
    
    //Open file specified
    File file = new File(args[0]);
    errorCont:
    //Driver function, will run at least once, it will continue to as long as input is 'y'
    do {
    try {
      //Create a new MileRedeemer object for driver and scanner for file
      MileRedeemer redeem = new MileRedeemer();
      Scanner sc = new Scanner(file);
      //Read in destinations
      MileTicket[] dests = redeem.readDestinations(sc);

      //Formatting
      System.out.println("------------------------------------");
      System.out.println("List of destination cities you can travel to:");

      //UI to ask for user input, loop through the destinations available
      for (int i = 0; i < dests.length; i++){
        //Print out cities + formatting
        System.out.println(dests[i].getCity());
      }
      
      //Continue with formatting and messages for user
      System.out.println("------------------------------------");
      System.out.println("Please input your total accumulated miles:");
      int totalMiles = cons.nextInt();
      System.out.println("Please input your month of departure (1-12):");
      int deptMonth = cons.nextInt();

      //Insert data into redeem function
      redeem.redeem(totalMiles, deptMonth, dests);
      System.out.println("");

      //Error catching and exception handling
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (InputMismatchException e) {
        e.printStackTrace();
      } finally {
      System.out.println("Do you want to continue (y/n)?");
      cont = cons.next().charAt(0);  
      }
    } while(cont == 'y');
    //Close scanner
    cons.close();
  }
}
