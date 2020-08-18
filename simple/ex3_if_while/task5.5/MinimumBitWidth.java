public class MinimumBitWidth
{
  public static void main(String [] args)
  {
    int noofVal = Integer.parseInt(args[0]);
    int pow = 1;
    int noofBits = 0;
    while (pow < noofVal) {
      pow = pow * 2;
      noofBits++;
    }
    System.out.println("You need " + noofBits + " bits to represent " + noofVal);
  }
}

