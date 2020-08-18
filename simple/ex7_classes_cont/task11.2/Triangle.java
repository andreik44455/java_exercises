public class Triangle
{
  private Point pointA, pointB, pointC;
  public Triangle(Point requiredA, Point requiredB, Point requiredC)
  {
    pointA = requiredA;
    pointB = requiredB;
    pointC = requiredC;
  }//constructor object Point
  
  public double area()
  {
    double sideA = pointA.distanceFromPoint(pointB);
    double sideB = pointA.distanceFromPoint(pointC);
    double sideC = pointB.distanceFromPoint(pointC);
    double semiPerimeter = (sideA + sideB + sideC)/2;
    return Math.sqrt(semiPerimeter*(semiPerimeter-sideA)
                     *(semiPerimeter-sideB)*(semiPerimeter-sideC));
  }//area

  public double perimeter()
  {
    double sideA = pointA.distanceFromPoint(pointB);
    double sideB = pointA.distanceFromPoint(pointC);
    double sideC = pointB.distanceFromPoint(pointC);
    return sideA + sideB + sideC;
  }//perimeter

  public Triangle shift(double xShift, double yShift)
  {
    Point shiftPointA = new Point(pointA.getX()+xShift,pointA.getY()+yShift);
    Point shiftPointB = new Point(pointB.getX()+xShift,pointB.getY()+yShift);
    Point shiftPointC = new Point(pointC.getX()+xShift,pointC.getY()+yShift);
    return new Triangle(shiftPointA, shiftPointB, shiftPointC);
  }//shifted Triangle
   
  public String toString()
  {
    return "((" + pointA + "),(" + pointB + "),(" + pointC + "))";
  }
   
}//class Triangle

