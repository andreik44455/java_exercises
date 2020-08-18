// Class has one class generic method with one type parameter
// that is comparable with itself.
// It will return an instance f the generic class Pair, comprising
// minimum and maximum items from the given array.
public class MinMaxArray {
  public static <ArrayType extends Comparable<ArrayType>>
                Pair<ArrayType, ArrayType> MinMax(ArrayType[] anArray)
                throws IllegalArgumentException {
    try {
      ArrayType max = anArray[0];
      ArrayType min = anArray[0];
      for (int index = 1; index < anArray.length; index++) {
        if (max.compareTo(anArray[index]) < 0)
          max = anArray[index];
        if (min.compareTo(anArray[index]) > 0)
            min = anArray[index];
      }// for
      return new Pair<ArrayType, ArrayType>(max, min);
    }// try
    catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Array must exist and be non-empty"); }
    catch (NullPointerException e) {
      throw new IllegalArgumentException("Array must exist", e); }
  }// MinMax
}// class MinMaxArray

