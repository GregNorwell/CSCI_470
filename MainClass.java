import java.io.*;
import java.util.*;

public class MainClass {
  public static void main(String[] args) {
    char cont = 'n';
    Scanner cons = new Scanner(System.in);
    if(args.length != 1) {
      System.out.println("Command line arg filename error");
      return;
    }
    File file = new File(args[0]);
    errorCont:
    do {
    try {
      MileRedeemer redeem = new MileRedeemer();
      Scanner sc = new Scanner(file);
      MileTicket[] dests = redeem.readDestinations(sc);
      
      System.out.println("------------------------------------");
      System.out.println("List of destination cities you can travel to:");
      for (int i = 0; i < dests.length; i++)
        System.out.println(dests[i].getCity());
      System.out.println("------------------------------------");
      System.out.println("Please input your total accumulated miles:");
      int totalMiles = cons.nextInt();
      System.out.println("Please input your month of departure (1-12):");
      int deptMonth = cons.nextInt();
      redeem.redeem(totalMiles, deptMonth, dests);
      System.out.println("");
      
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (InputMismatchException e) {
        e.printStackTrace();
    } finally {
      System.out.println("Do you want to continue (y/n)?");
      cont = cons.next().charAt(0);  
    }
    } while(cont == 'y');
    
  }
}
