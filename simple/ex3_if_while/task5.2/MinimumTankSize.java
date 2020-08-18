public class MinimumTankSize
{
  public static void main(String [] args)
  {
    double RecVol = Double.parseDouble(args[0]);
    double L = 0.5;
    while (L * L * L < RecVol)
      L = L + 0.5;
    System.out.println("You need a tank of " + L + " metres per side to hold the volume " + RecVol + " cubic metres");
  }
}



