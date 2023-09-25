import java.util.Scanner; //Import Scanner class
public class ASCIIArt
{
  public static void main(String[] args)
  {
    int shapeInt;
    Scanner myScan = new Scanner(System.in);  //set up scanner named myScan

    System.out.println("1: Trapezoid  2: Heptagon\n3: Rectangle  4: Right Triangle\n5: Square");
    System.out.println("Enter number for shape:");
    shapeInt = myScan.nextInt();  //recieve the shapeInt as an int
    
    switch (shapeInt){
      case 1:
        System.out.println("    *******");
        System.out.println("   *       *");
        System.out.println("  *         *");
        System.out.println(" *           *");
        System.out.println("***************");
        break;
      case 2:
        System.out.println("      *");
        System.out.println("  ***   ***");
        System.out.println("*           *");
        System.out.println(" ***     ***");
        System.out.println("    *****");
        break;
      case 3:
        System.out.println("*****************");
        for (int i = 0; i < 7; i++)
          System.out.println("*               *");
        System.out.println("*****************");
        break;
      case 4:
        System.out.println("*");
        System.out.println("* *");
        System.out.println("*   *");
        System.out.println("*     *");
        System.out.println("********");
        break;
      case 5:
        System.out.println("*****************");
        for (int i = 0; i < 4; i++)
          System.out.println("*               *");
        System.out.println("*****************");
        break;
      default:
        System.out.println("Error: Invalid Selection");
    }
  }
}
