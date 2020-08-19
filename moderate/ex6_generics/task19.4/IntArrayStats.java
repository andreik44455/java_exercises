// Contains the method to find maximum & minimum integers in an array and
// its mean.
public class IntArrayStats {
  //  Find maximum and minimum integers in the given array and its mean.
  // Return a Triple maximum, minimum and mean.
  // Throw IlligalArgumentException if array is null or empty.
  public static Triple<Integer,Integer, Double> getStats(int[] array) 
		                             throws IllegalArgumentException {
    if (array == null || array.length == 0)
      throw new IllegalArgumentException("Array must exist and be non-empty");
    int max = array[0];
    int min = array[0];
    double mean = array[0];
    for (int index = 1; index < array.length; index++) {
      if(max < array[index])
        max = array[index];
      if(min > array[index])
        min = array[index];
      mean += array[index];
    }// for
    mean /= array.length;
	  
    return new Triple<Integer, Integer, Double>(max, min, mean);
	  
  }//getStats
}// class IntArrayStats

