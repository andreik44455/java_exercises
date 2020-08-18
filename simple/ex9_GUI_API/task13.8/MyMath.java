public class MyMath {
	
  public static int greatestCommonDivisor ( int mult1GCD, int mult2GCD)
  {
    //Find GCD between 2 numbers
    while (mult1GCD != mult2GCD)
      if (mult1GCD>mult2GCD)
        mult1GCD-=mult2GCD;
      else 
        mult2GCD-=mult1GCD;
        
    return mult1GCD;
              
  } // greatestCommonDivisor
} // class MyMath
