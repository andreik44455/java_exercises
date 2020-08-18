public class Circle
{
  private Point centre;
  private double radius;
  public Circle (Point requiredC, double requiredR)
  {
    centre = requiredC;
    radius = requiredR;
  }//constructor object Point

  public double area()
  {
    return Math.PI * (radius * radius);
  }//area

  public double perimeter()
  {
    return 2 * Math.PI * radius;
  }//perimeter

  public Circle shift(double xShift, double yShift)
  {
    Point shiftCentre = new Point((centre.getX()+xShift),(centre.getY()+yShift));
    return new Circle(shiftCentre, radius);
  }//shifted circle
   
  public String toString()
  {
  return "Circle((" + centre + "), " + radius + ")";
  }
   
}//class Circle

