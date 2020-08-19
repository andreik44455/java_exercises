// Two items grouped in pair
public class Pair<FirstType, SecondType> {
  private final FirstType first;
  private final SecondType second;
  
  // constructor
  public Pair(FirstType requiredFirst, SecondType requiredSecond) {
    first = requiredFirst;
    second = requiredSecond;
  }// Triple
  
  public FirstType getFirst() {
    return first;
  }// getFirst
  
  public SecondType getSecond() {
    return second;
  }// getSecond

}// class Pair
