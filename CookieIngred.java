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
    cookies = myScan.nextInt();
    sugarC = Math.ceil(cookies / 48.0) * 2;
    butterC = Math.ceil(cookies / 48.0);
    flourC = Math.ceil(cookies / 48.0) * 3;

    System.out.println("To make " + (int) cookies + " cookies, it will require:");
    System.out.println(sugarC + " cups of sugar\n" + butterC + " cups of butter\n" + flourC + " cups of flour");
  }
}
