                                                                                                                   
public class LargestSquare
{
  public static void main(String [] args)
  {
    double x = Double.parseDouble(args[0]);
    int number = 0;

    while (Math.pow(number,2) <= x)
      number = number + 1;
     
    System.out.println(number-1 + " is the largest square number to a given number " + x);
   }
}



