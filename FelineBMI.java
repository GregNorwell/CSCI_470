//This program calculates a cat's BMI
import java.util.Scanner; //Import Scanner class
public class FelineBMI
{
  public static void main(String[] args)
  {
    double ribCircum, legLength, fbmi;
    Scanner myScan = new Scanner(System.in);  //set up scanner named myScan
    
    System.out.println("Enter rib circumfrence of the cat:");
    ribCircum = myScan.nextDouble();  //recive the ribCircumfrence as an double

    System.out.println("Enter leg length of the cat:");
    legLength = myScan.nextDouble();  //recive the legLength as an double

    //function to calculate Feline BMI
    fbmi = ((ribCircum / 0.7062) - legLength) / 0.9156 - legLength;
    switch (fbmi){
    case (fbmi >= 40):
      System.out.println("Very Obese");
      break;
    case (fbmi < 40):
      System.out.println("Obese");
      break;
    case (fbmi < 35):
      System.out.println("Overweight");
      break;
    case (fbmi < 30):
      System.out.println("Normal");
      break;
    case (fbmi < 15):
      System.out.println("Underweight");
      break; 
    case (fbmi < 10):
      System.out.println("Very Underweight");
      break;
    default:
      System.out.println("Error out of range");
    }
  }
}
