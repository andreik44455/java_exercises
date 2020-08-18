// Class that tests MinMaxArray.
// Creates an array of Integers from input and parse it
// to the method in the MinMaxArray. This method returns
// a pair of maximum and minimum items in the given array.
public class TestMinMaxArray {
  public static void main(String[] args) {
    Integer[] array = new Integer[args.length];
    for (int index = 0; index < args.length; index++)
      array[index] = Integer.parseInt(args[index]);
		    
	Pair<Integer, Integer> stats = MinMaxArray.MinMax(array);
	int max = stats.getFirst();
	int min = stats.getSecond();
	System.out.println("Minimum: " + min + "Maximum: " + max);
		    
  }// main
}// class TestMinMaxArray
