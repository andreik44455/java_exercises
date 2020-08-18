public class QuadPoly 
{
  private double a, b, c;
  public QuadPoly (double requiredA, double requiredB, double requiredC)
  {
    a = requiredA;
    b = requiredB;
    c = requiredC;
  }//constructor object QuadPoly 

  public boolean lessThen(QuadPoly other)
  {
    return a < other.a 
           || a == other.a 
           && (b < other.b 
           || b == other.b && c < other.c);
  }//instance method lessThen

  public boolean equals(QuadPoly other)
  {
    return a == other.a && b == other.b && c == other.c;
  }//equals

  public String toString()
  {
    return a + "x^2 + " + b + "x + " + c;
  }//toString

  public QuadPoly add(QuadPoly other)
  {
    return new QuadPoly(a+other.a, b+other.c, c+other.c);
  }//add
}//class QuadPoly


