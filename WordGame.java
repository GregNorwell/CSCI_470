// This program writes a story using user input
import java.util.Scanner; //Import Scanner class
public class WordGame
{
  public static void main(String[] args)
  {
    Scanner myScan = new Scanner(System.in);  //set up scanner named myScan
    System.out.println("Enter Name:");
    String name = myScan.nextLine();  //collect name
    System.out.println("Enter Age:");
    String age = myScan.nextLine();  //collect age
    System.out.println("Enter City:");
    String city = myScan.nextLine();  //collect city name
    System.out.println("Enter Animal Name:");
    String aName = myScan.nextLine();  //collect name of Animal
    System.out.println("Enter Pet Name:");
    String pName = myScan.nextLine();  //collect pet name

    System.out.println(name + " lived in " + city + ". At the age of " + age + " he adopted a(n) " + aName + " named " + pName);
    System.out.println();  //skip line
    System.out.println(name + " then ate that " + aName + " named " + pName + " shocking all of " + city + " when they were only " + age + " years old.");
  }
}
