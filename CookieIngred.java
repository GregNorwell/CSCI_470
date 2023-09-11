import java.util.Scanner; //Import Scanner class
public class CookieIngred
{
  public static void main(String[] args)
  {
    Scanner myScan = new Scanner(System.in);  //set up scanner named myScan
    int sugarC;    //cups of sugar count
    int butterC;   //cups of butter count
    int flourC;    //cups of flour count
    int cookies;   //desired cookies
    System.out.println("Enter the desired amount of cookies:");
    cookies = myScan.nextInt();
    sugarC = (cookies / 48) * 2;
    butterC = (cookies / 48);
    flourC = (cookies / 48) * 3;

    System.out.println("To make " + cookies + " cookies, it will require:");
    System.out.println(sugarC + " cups of sugar\n" + butterC + " cups of butter\n" + flourC + " cups of flour");
  }
}
