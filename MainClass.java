import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) {
    File file = new File("dest.txt");
    try {
      Scanner sc = new Scanner(file);
      readDestinations(sc);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
  }
}
