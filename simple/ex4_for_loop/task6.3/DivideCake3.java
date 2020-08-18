public class DivideCake3
{
   public static void main(String [] args)
   {
    // Input ages of 3 sisters
    int age1 = Integer.parseInt(args[0]);
    int age2 = Integer.parseInt(args[1]);
    int age3 = Integer.parseInt(args[2]);
    
    //Muiltiples of GCD(1, 2, 3), initially age1, age2, age3
    int mult1GCD = age1;
    int mult2GCD = age2;
    int mult3GCD = age3;
    
    //Find GCD between first 2 sisters
    while (mult1GCD != mult2GCD)
      if (mult1GCD > mult2GCD)
        mult1GCD -= mult2GCD;
      else 
        mult2GCD -= mult1GCD;
    
    //Find GCD between GCD of first 2 sisters and the third sister
    while (mult1GCD != mult3GCD)
      if (mult1GCD > mult3GCD)
        mult1GCD -= mult3GCD;
      else 
        mult3GCD -= mult1GCD;
    
    //GCD of age1, age2 and age3
    System.out.println("The GCD of " + age1 + ", " + age2 +
                       " and " + age3 + " is " + mult1GCD);
  
    //calculation the number of portions for each sister
    int noOfPortions1 = age1/mult1GCD;
    int noOfPortions2 = age2/mult1GCD;
    int noOfPortions3 = age3/mult1GCD;
    
    //Total number of portions
    System.out.println("Cake should be divided into " + 
      (noOfPortions1 + noOfPortions2 + noOfPortions1) + " portions");
    
    //number of portions for each sister
    System.out.println("The " + age1 + " years old gets " + noOfPortions1 +
      ", " + age2 + " years old gets " + noOfPortions2 + " and the "
      + age3 + " years old gets " + noOfPortions3);
  
   } // main
} // class DivideCake3
