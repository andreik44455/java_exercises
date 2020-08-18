public class PrintHoledRectangle
{
  public static void main(String [] args)
  {
    //Input width and height
    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);
    
    // odd width and height
    int oddwidth = width/2*2 + 1;
    int oddheight = height/2*2 + 1;
    
    //the centre cell
    int centre = oddheight*oddwidth/2 + 1;
    int count=0;

    for (int row = 1; row <= oddheight; row++) {
      for (int column = 1; column <= oddwidth; column++) {
        count++;     
        if (count == centre)
          System.out.print("   ");
        else
          System.out.print("[_]");
      }
      System.out.println(); 
    }   
  } // main
} // class PrintHoledRectangle
