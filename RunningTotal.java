import java.util.Scanner;
public class RunningTotal {
  private int product = 1;
  private int sum = 0;
  private int largestNumber = 0;
  private int totalNumbersEntered = 0;
  Scanner scan = new Scanner(system.in);

//This method will use a while loop to continuously ask the user for positive numbers
  public void getNumbersFromUser()
  {
    while(true)
    {
      System.out.println("Please enter a positive number: (0 to finish)");
      int input = scan.nextInt();
      if (input == 0)
        break;
      if (input > 0)
      {
        sum = sum + input;
        product = product * input;
        if (input > largestNumber)
          largestNumber = input;
        totalNumbersEntered++;
      }
    }
  }
  //return the average of all users’ entered numbers (except the negative one).
  public int getAverage()
  {
    return (product / totalNumbersEntered);
  }
  //return the value of the product attribute
  public int getProduct()
  {
    return product;
  }
  // return the value of the sum attribute
  public int getSum()
  {
    return sum;
  }
  //return the value of the largestNumber attribute
  public int getLargestNumber()
  {
    return largestNumber;
  }
}
