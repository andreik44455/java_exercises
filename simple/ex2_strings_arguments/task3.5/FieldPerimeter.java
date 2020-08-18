public class FieldPerimeter
{
  public static void main(String[] args)
  {
    int Length = Integer.parseInt(args[0]);
    int Width = Integer.parseInt(args[0]);
    int Perimeter = 2 * (Length+Width);
    System.out.println("The perimeter of a field with dimensions ("
                       + Length + "," + Width + ") is " + Perimeter);
  }
}
