public class CompareQuadPoly
{ 
  public static void main (String [] args)
  {
    QuadPoly coeff = new QuadPoly(Integer.parseInt(args[0]),
                         Integer.parseInt(args[1]),
                         Integer.parseInt(args[2]));
    QuadPoly coeff2 = new QuadPoly(Integer.parseInt(args[3]),
                                   Integer.parseInt(args[4]),
                                   Integer.parseInt(args[5]));
    if (coeff.lessThen(coeff2))
    {
      System.out.println("The polynomial:   " + coeff.a + "x^2 + " + coeff.b
                       + "x + " + coeff.c);
      System.out.println("is smaller than : " + coeff2.a + "x^2 + " + coeff2.b
                         + "x + " + coeff2.c);
    }//if
    else 
      if (coeff.equals(coeff2))
      {    
        System.out.println("The polynomial: " + coeff.a + "x^2 + " + coeff.b
                           + "x + " + coeff.c);
        System.out.println("is the same as: " + coeff2.a + "x^2 + " + coeff2.b
                           + "x + " + coeff2.c);
      }//if
      else 
      {    
        System.out.println("The polynomial:  " + coeff.a + "x^2 + " + coeff.b + "x + " + coeff.c);
        System.out.println("is greater than: " + coeff2.a + "x^2 + " + coeff2.b + "x + " + coeff2.c);
      }//else
  }//main
}//class 

