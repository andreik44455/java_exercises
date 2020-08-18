public class FahrenheitToCelsius
{
  public static void main(String [] args)
  {
    double F = Double.parseDouble(args[0]);
    double C = (F - 32) * 5/9;
    System.out.println(F + " Fahrenheit equals to " + C + " Celsius");
  }
}
