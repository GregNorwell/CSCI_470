import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) {
    File file = new File(args[0]);
    MileRedeemer redeem = new MileRedeemer();
    try {
      Scanner sc = new Scanner(file);
      Scanner cons = new Scanner(System.in);
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
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
  }
}
