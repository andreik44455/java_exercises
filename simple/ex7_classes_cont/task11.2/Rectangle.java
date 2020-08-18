public class Rectangle
{
  private Point pointA, pointB, pointC, pointD;

  public Rectangle(Point requiredA, Point requiredC)
  {
    pointA = requiredA;
    pointB = new Point(requiredA.getX(),requiredC.getY());
    pointC = requiredC;
    pointD = new Point(requiredC.getX(),requiredA.getY());
  }//constructor object Point
  
  public double area()
  {
    double sideA = pointA.distanceFromPoint(pointB);
    double sideB = pointA.distanceFromPoint(pointD);
    return sideA*sideB;
  }//area

  public double perimeter()
  {
    double sideA = pointA.distanceFromPoint(pointB);
    double sideB = pointA.distanceFromPoint(pointD);
    return 2*(sideA + sideB);
  }//perimeter

  public Rectangle shift(double xShift, double yShift)
  {
    Point shiftPointA = new Point(pointA.getX()+xShift,pointA.getY()+yShift);
    Point shiftPointB = new Point(pointB.getX()+xShift,pointB.getY()+yShift);
    Point shiftPointC = new Point(pointC.getX()+xShift,pointC.getY()+yShift);
    Point shiftPointD = new Point(pointD.getX()+xShift,pointD.getY()+yShift);
    return new Rectangle(shiftPointA, shiftPointC);
  }//shifted Rectangle
   
  public String toString()
  {
  return "((" + pointA + "),(" + pointB + "),(" + pointC + "), (" + pointD + "))";
  }//toString
   
}//class Rectangle
