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

    /*statements to determine class based on:
    Very Obese 40 and above
    Obese 35 to <40
    Overweight 30 to <35
    Normal 15 to <30
    Underweight 10 to <15
    Very Underweight Below 10
    */
    if (fbmi >= 40){
      System.out.println("Very Obese");
    }
    else if (fbmi >= 35 && fbmi < 40){
      System.out.println("Obese");
    }
    else if (fbmi >= 30 && fbmi < 35){
      System.out.println("Overweight");
    }
    else if (fbmi >= 15 && fbmi < 30){
      System.out.println("Normal");
    }
    else if (fbmi >= 10 && fbmi < 15){
      System.out.println("Underweight");
    }
    else if (fbmi < 10){
      System.out.println("Very Underweight");
    }
    else{
      System.out.println("Error out of range");
    }
  }
}
