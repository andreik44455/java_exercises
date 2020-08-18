                                                                                                                   
public class DegreeCategory
{
  public static void main(String [] args)
  {
    double grade = Double.parseDouble(args[0]);
  
    if (grade >= 70)
      System.out.println("Honours, first class");
    else if (grade >= 60)
      System.out.println("Honours, second class, division one");
         else if (grade >= 50)
           System.out.println("Honours, second class, division two");
              else if (grade >= 40)
                System.out.println("Honours, third class");
                   else if (grade >= 32)
                     System.out.println("Pass/ ordinary degree");
                        else System.out.println("Fail");
  }
}



