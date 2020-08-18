public class SumOfCubedDigits
{
   public static void main(String[] args)
   {
    for (int digit = 0; digit <= 9; digit++)
      for (int digit1 = 0; digit1 <= 9; digit1++)
        for (int digit2 = 1; digit2 <=9; digit2++)
          //compare all numbers from 100 to 999
          if (digit + digit1*10 + digit2*100 == 
              digit*digit*digit +
              digit1*digit1*digit1 + 
              digit2*digit2*digit2)
            System.out.println(digit + digit1*10 + digit2*100);
   }//main
}//class SumOfCubedDigits
