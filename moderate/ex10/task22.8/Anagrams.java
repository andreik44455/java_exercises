// This program outputs all permutations of a string given as a command line
// argument. 
public class Anagrams {

  private static boolean [] isCharUsed;
  private static char [] currentString;
  private static char [] characters;
  
  public static void main(String[] args) {
    // Turn the first command line argument into a char array.
    characters =  args[0].toCharArray();
    // Array to build the current permutation.
    currentString = new char[characters.length];
    // Array to record whether the character from the given string
    // have been used so far in the permutation being constructed.
    isCharUsed = new boolean[characters.length];
    // Call recursive method to print all the permutations.
    printPermutations(0);
  }// main

  // Recursive method to build permutations.
  private static void printPermutations(int currentIndex) {
    // If currentIndex has gone past the end of the permutation array
    if (currentIndex > characters.length-1)
      // Print out the permutation
      System.out.println(currentString);
    else
      // For each index in the char array made from the given string
      for (int index = 0; index <= characters.length-1; index++)
    	// If character at that index is not already used in the permutation
        if (isCharUsed[index] == false) {
          // Mark it as being in use
          isCharUsed[index] = true;
          // Put that character in the permutation at currentIndex
          currentString[currentIndex] = characters[index];
          // Call the method and parse increased index
          printPermutations(currentIndex+1);
          // Mark character as not being used in the permutation
          isCharUsed[index] = false;
        }// if
  }// printPermutations
}// class Anagrams
