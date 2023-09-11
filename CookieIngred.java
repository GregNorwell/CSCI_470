//This program displays the required ingredients for a user input number of cookies
import java.util.Scanner; //Import Scanner class
public class CookieIngred
{
  public static void main(String[] args)
  {
    Scanner myScan = new Scanner(System.in);  //set up scanner named myScan
    double sugarC;    //cups of sugar count
    double butterC;   //cups of butter count
    double flourC;    //cups of flour count
    double cookies;   //desired cookies
    System.out.println("Enter the desired amount of cookies:");
    cookies = myScan.nextInt();  //recive the desired number of cookies as an int

    //calculate the sugar, butter, and flour required
    //Math.ceil is used to always round up the result of cookies divided by 48 if it is not evenly divisible by 48
    sugarC = Math.ceil(cookies / 48.0) * 2;
    butterC = Math.ceil(cookies / 48.0);
    flourC = Math.ceil(cookies / 48.0) * 3;

    //output result, cast to int to remove the .0 at the end
    System.out.println("To make " + (int) cookies + " cookies, it will require:");
    System.out.println((int) sugarC + " cups of sugar\n" + (int) butterC + " cups of butter\n" + (int) flourC + " cups of flour");
  }
}
