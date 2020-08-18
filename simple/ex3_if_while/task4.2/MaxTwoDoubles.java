public class MaxTwoDoubles
{
  public static void main(String [] args)
  {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
  
    if (x > y)
      System.out.println("The maximum number is " + x);
    else
      System.out.println("The maximum number is " + y);
  }
}
