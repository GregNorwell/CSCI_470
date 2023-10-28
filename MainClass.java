public class MainClass {
  public static void main(String[] args) {
    RunningTotal RunningTot = new RunningTotal(); //Create running total instance
    RunningTot.getNumbersFromUser(); //run loop
    System.out.println("Finished Product:" + RunningTot.getProduct()); //print product
    System.out.println("Finished Sum:" + RunningTot.getSum()); //print sum
    System.out.println("Finished Largest Number:" + RunningTot.getLargestNumber()); //print largest number
    System.out.println("Average:" + RunningTot.getAverage()); //print average
  }
}
