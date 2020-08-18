                                                                                                                   
public class PassFailDistinction
{
  public static void main(String [] args)
  {
    double grade = Double.parseDouble(args[0]);
   
    if (grade < 50)
      System.out.println("Fail");
    else if (grade < 70)
      System.out.println("Pass");
    else { 
      System.out.println("Pass");
      System.out.println("Distinction");
    }
  }
}



