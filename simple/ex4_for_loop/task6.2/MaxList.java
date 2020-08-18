public class MaxList
{
  public static void main(String [] args)
  {
    // input list of number
    double x = Double.parseDouble(args[0]);
    
    // maximum number is the first number(then compare to others)
    double max=x;
    
    // index of the first number
    int indexOfNumber=0;

    // we deal with other number to find the maximum
    for (int index = 1; index < args.length; index++) { 
      x = Double.parseDouble(args[index]);
      if (x > max) {
        max = x;
        indexOfNumber = index;
      }
    }
      
    //output the maximum value and its index
    System.out.println("The maximum number in the list is " + max
                       + " in the position " + indexOfNumber);  

  } // main
} // class MaxList
