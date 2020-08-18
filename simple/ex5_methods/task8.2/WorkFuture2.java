public class WorkFuture2
{
  public static void main(String [] args)
  {
    //The year of present day
    int presentYear = Integer.parseInt(args[0]);

    //The year of birth
    int birthYear1 = Integer.parseInt(args[1]);
    int birthYear2 = Integer.parseInt(args[2]);
    //Years old in present year
    int age1 = presentYear-birthYear1;
    int age2 = presentYear-birthYear2;
    // Age of retirement
    int retireAge = 68;

    //The first output: how many year left to work
    System.out.println("Pn 1 has " + (retireAge-age1) + " years left to work");

    //Year of retirement
    int yearofRetire1 = birthYear1 + retireAge;
    int yearofRetire2 = birthYear2 + retireAge;
    
    //some year
    int someYear1 = presentYear;
    int someYear2 = presentYear;
    
    //FIRST PERSON    
    //We output each year before the year of retirement
    while (someYear1 < yearofRetire1 - 1) { 
      someYear1++;
      age1++;
      System.out.println("In " + someYear1 + " Pn1 will have " + 
      (retireAge-age1) + " years left to work");
    } //while

    //output the year of retirement
    System.out.println("Pn1 will retire in " + yearofRetire1);
    
    //SECOND PERSON 
    System.out.println("Pn 2 has " + (retireAge-age2) + " years left to work");
    //We output each year before the year of retirement
    while (someYear2 < yearofRetire2 - 1) { 
      someYear2++;
      age2++;
      System.out.println("In " + someYear2 + " Pn2 will have " + 
      (retireAge-age2) + " years left to work");
    } //while

    //output the year of retirement
    System.out.println("Pn2 will retire in " + yearofRetire2);
   } // main
} // class WorkFuture
