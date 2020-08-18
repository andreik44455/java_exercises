public class Variance
{
  public static void main(String [] args)
  {
    int sum = Integer.parseInt(args[0]);
    for (int index = 1; index < args.length; index++ )
      sum = sum + Integer.parseInt(args[index]);
   
    double mean = sum / (double) args.length;
    double x = 0;
    for (int index = 0; index < args.length; index++ )
      x = x + Math.pow(Integer.parseInt(args[index]) - mean, 2);

    System.out.println("The variance is " + x / (double) args.length);
    System.out.println("The mean average is " + sum / (double) args.length);  
  }
}
