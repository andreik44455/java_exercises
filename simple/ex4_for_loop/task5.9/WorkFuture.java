public class WorkFuture
{
  public static void main(String [] args)
  {
    // The year of present day
    int presentYear = Integer.parseInt(args[0]);

    // The year of birth
    int birthYear = Integer.parseInt(args[1]);

    // Years old in present year
    int age = presentYear-birthYear;

    // Age of retirement
    int retireAge = 68;

    // The first output: how many year left to work
    System.out.println("You have " + (retireAge-age) + " years left to work");

    // Year of retirement
    int yearofRetire = birthYear + retireAge;
    
    // We output each year before the year of retirement
    while (presentYear < yearofRetire-1) { 
      presentYear++;
      age++;
      System.out.println("In " + presentYear + " you will have " + 
      (retireAge-age) + " years left to work");
    } // while

    // output the year of retirement
    System.out.println("You will retire in " + ++presentYear);
     
  } // main
} // class WorkFuture
