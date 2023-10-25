java.util.GregorianCalendar
public class Car
{
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
    GregorianCalendar gcal = new GregorianCalendar();
    if(brand.equals("NA"))
      return false;
    if(mpg <= 25.0)
      return false;
    if((gcal.get(calendar.YEAR) - 15) >= year)
      return false;
    return true;
  }
}
