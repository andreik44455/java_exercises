public class YearsBeforeRetirement
{
  public static void main(String[] args)
  {
    int MyAgeNow = Integer.parseInt(args[0]);
    int MyRetAge = 68;
    int YearsLeft = MyRetAge - MyAgeNow;
    System.out.println("My age now is " + MyAgeNow
                       + "\nI will retire at the age of " + MyRetAge
                       + "\nYears left working is " + YearsLeft);
  }
}

