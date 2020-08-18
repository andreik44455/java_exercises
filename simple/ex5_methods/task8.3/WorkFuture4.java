public class WorkFuture4 {
  public static void main(String[] args)
  {
      // present year
      int presentYear = Integer.parseInt(args[0]);
      
      // year of birth of 2 pns
      int birthYear1 = Integer.parseInt(args[1]);
      int birthYear2 = Integer.parseInt(args[2]);
      int birthYear3 = Integer.parseInt(args[3]);
      int birthYear4 = Integer.parseInt(args[4]);
      
      printYearsOfRetirement(presentYear, 1, birthYear1);
      printYearsOfRetirement(presentYear, 2, birthYear2);
      printYearsOfRetirement(presentYear, 3, birthYear3);
      printYearsOfRetirement(presentYear, 4, birthYear4);
  } // main
      
      // print years of retirement of one person
  private static void printYearsOfRetirement (int presentYear,
                                              int personNumber, int birthYear)
  {
      // age of retirement
      int retireAge = 68;
          
      // age of pns
      int age = presentYear - birthYear;
          
      // date of birth of a person
      System.out.println("Pn " + personNumber + " has " + (retireAge-age) 
                         + " years left to work");
      // Year of retirement
      int yearofRetire = birthYear + retireAge;
            
      // We output each year before the year of retirement
      while (presentYear < yearofRetire-1) { 
        presentYear++;
        age++;
        System.out.println("In " + presentYear + " Pn" + personNumber
                           + " will have " + (retireAge-age) 
                           + " years left to work");
      } // while

      // output the year of retirement
      System.out.println("Pn " + personNumber + " will retire in " 
                         + yearofRetire);  
  } // printYearsOfRetirement
}//WorkFuture4

