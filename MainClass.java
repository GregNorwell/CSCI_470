public class MainClass {
  public static void main(String[] args) {
    RunningTot = new RunningTotal(); //Create running total instance
    RunningTot.GetNumbersFromUser();
    System.out.println("Finished Product:" RunningTot.getProduct());
    System.out.println("Finished Sum:" RunningTot.getSum());
    System.out.println("Finished Largest Number:" RunningTot.getLargestNumber());
    System.out.println("Average:" RunningTot.getAverage());
  }
}
