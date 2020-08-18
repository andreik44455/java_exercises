public class AddQuadPoly 
{
  
  public static void main (String [] args)
  {
    QuadPoly coeff = new QuadPoly(Integer.parseInt(args[0]),
                         Integer.parseInt(args[1]),
                         Integer.parseInt(args[2]));
    QuadPoly coeff2 = new QuadPoly(Integer.parseInt(args[3]),
                                   Integer.parseInt(args[4]),
                                   Integer.parseInt(args[5]));
    QuadPoly coeff3 = new QuadPoly(coeff.a+coeff2.a, coeff.b+coeff2.b,
                                   coeff.c+coeff2.c);
    System.out.println("Polynomial: " + coeff.a + "x^2 + " + coeff.b + "x + " + coeff.c);
    System.out.println("added to:   " + coeff2.a + "x^2 + " + coeff2.b + "x + " + coeff2.c);
    System.out.println("results in: " + coeff3.a + "x^2 + " + coeff3.b + "x + " + coeff3.c);
  }
}

