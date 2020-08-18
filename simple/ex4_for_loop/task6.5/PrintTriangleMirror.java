public class PrintTriangleMirror
{
  public static void main(String [] args)
  {
    //Input height
    int height = Integer.parseInt(args[0]);
      
    for (int row = 0; row < height; row++) {
      //number of spaces
      for (int spaces = 0; spaces < row; spaces++)
       System.out.print("   ");
     
      //number of squares      
      for (int squares = height; squares > row; squares--)
        System.out.print("[_]"); 
      
      System.out.println(); 
    }//for          
  } // main
} // class PrintTriangleMirror
