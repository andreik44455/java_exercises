public class RoundPennies
{
  public static void main(String [] args)
  {
    int pennies = Integer.parseInt(args[0]);
    int pounds = (pennies + 50) / 100;
    System.out.println(pennies + " pennies equals to " + pounds + " pounds");
  }
}
