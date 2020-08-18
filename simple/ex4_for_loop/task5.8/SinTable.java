public class SinTable
{
  public static void main(String [] args)
  {
    double start = Double.parseDouble(args[0]);
    double step = Double.parseDouble(args[1]);
    double end = Double.parseDouble(args[2]);

    System.out.println("--------------------------------------------------");
    System.out.println("|  Sin table from " + start + " to " + end + 
    " in steps of " + step);
    System.out.println("--------------------------------------------------");

    for (double number = start; number <= end; number += step) {
      double x = Math.sin(Math.toRadians(number));
      System.out.println("|  sin(" + number + ") = " + x);
    } 
    System.out.println("--------------------------------------------------");
  }
}
