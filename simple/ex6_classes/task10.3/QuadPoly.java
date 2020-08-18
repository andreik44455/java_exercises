public class QuadPoly 
{
  public double a, b, c;
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
  }
}//class QuadPoly


