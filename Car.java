import java.util.Calendar;
import java.util.GregorianCalendar;
public class Car
{
  GregorianCalendar gcal = new GregorianCalendar();
  private String modelName;
  private String brand;
  private int year;
  private double mpg;

  public Car(String brand, String modelName, int year, double mpg)
  {
    this.brand = brand;
    this.modelName = modelName;
    this.year = year;
    this.mpg = mpg;
  }
  public Car(String brand, int year, double mpg)
  {
    this.brand = brand;
    this.modelName = "NA";
    this.year = year;
    this.mpg = mpg;
  }

  public String getModelName()
  {
    return modelName;
  }
  public String getBrand()
  {
    return brand;
  }
  public int getYear()
  {
    return year;
  }
  public double getMPG()
  {
    return mpg;
  }
  public boolean isPractical()
  {
    if(brand.equals("NA"))
      return false;
    if(mpg <= 25.0)
      return false;
    if((gcal.get(Calendar.YEAR) - 15) >= year)
      return false;
    return true;
  }
}
