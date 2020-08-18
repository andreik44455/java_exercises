public class Point
{
  private double x, y;
  public Point (double requiredX, double requiredY)
  {
    x = requiredX;
    y = requiredY;
  }//constructor object Point 

  public double getX()
  {
    return x;
  }//getX
  
    public double getY()
  {
    return y;
  }//getY
  
  public double distanceFromPoint(Point otherPoint)
  {
    double xDistance = x - otherPoint.x;
    double yDistance = y - otherPoint.y;
    return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
  }// distanceFromPoint

  public String toString()
  {
    return x + "," + y;
  }//toString
   
}//class QuadPoly

