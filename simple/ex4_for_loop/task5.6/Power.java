public class Power
{
  public static void main(String [] args)
  {
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    int result = 1;
    for (int count = 1; count <= y; count++ )
      result *= x;
    System.out.println(x + " in power of " + y + " is equal to " + result);
  }
}
