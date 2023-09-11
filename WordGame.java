import java.util.Scanner; //Import Scanner class
public class WordGame
{
  public static void main(String[] args)
  {
    Scanner myScan = new Scanner(System.in);
    System.out.println("Enter Name:");
    String name = myScan.nextLine();
    System.out.println("Enter Age:");
    String age = myScan.nextLine();
    System.out.println("Enter City:");
    String city = myScan.nextLine();
    System.out.println("Enter Animal Name:");
    String aName = myScan.nextLine();
    System.out.println("Enter Pet Name:");
    String pName = myScan.nextLine();

    System.out.println(name + " lived in " + city + ". At the age of " + age + " he adopted a(n) " + aName + " named " + pName"); 
  }
}
