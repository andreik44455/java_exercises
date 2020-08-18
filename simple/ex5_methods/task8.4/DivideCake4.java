public class DivideCake4 {
  public static void main(String [] args)
  {
    // Input ages of 3 sisters
    int age1 = Integer.parseInt(args[0]);
    int age2 = Integer.parseInt(args[1]);
    int age3 = Integer.parseInt(args[2]);
    int age4 = Integer.parseInt(args[3]);
        
    int agesGCD1 = greatestCommonDivisor(age1, age2);
    int agesGCD2 = greatestCommonDivisor(agesGCD1,age3);
    int agesGCD = greatestCommonDivisor(agesGCD2,age4); 
    //GCD of age1, age2 and age3
    System.out.println("The GCD of " + age1 + ", " + age2 + ", " + age3 +
                       " and " + age4 + " is " + agesGCD);
      
    //calculation the number of portions for each sister
    int noOfPortions1 = age1/agesGCD;
    int noOfPortions2 = age2/agesGCD;
    int noOfPortions3 = age3/agesGCD;
    int noOfPortions4 = age4/agesGCD;
        
    //Total number of portions
    System.out.println("Cake should be divided into " + 
                       (noOfPortions1 + noOfPortions2 
                       + noOfPortions3+noOfPortions4)+ " portions");
        
    //number of portions for each sister
    System.out.println("The " + age1 + " years old gets " + noOfPortions1 +
                       ", the " + age2 + " years old gets " + noOfPortions2
                       + ", the "+ age3 + " years old gets "
                       + noOfPortions3 + " and the "
                       + age4 + " years old gets " + noOfPortions4);
        
  }
        
        
  private static int greatestCommonDivisor ( int mult1GCD, int mult2GCD)
  {
    // Find GCD between first 2 sisters
    while (mult1GCD != mult2GCD)
      if (mult1GCD>mult2GCD)
        mult1GCD-=mult2GCD;
      else 
        mult2GCD-=mult1GCD;
        
    return mult1GCD;  
  } // greatestCommonDivisor
} // class DivideCake3

