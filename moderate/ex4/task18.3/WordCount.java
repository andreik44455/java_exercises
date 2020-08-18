import java.io.InputStreamReader;
import java.io.IOException;
// Program to count the number of words on the standart input
// and report on the standart output.
public class WordCount {
  public static void main(String[] args){
    // We will read input as characters.
    InputStreamReader input = new InputStreamReader(System.in);
    
    // The total number of words so far.
    int wordCount = 0;

    try {
      int currentCharacter;
      int previousCharacter = 32;
      while ((currentCharacter = input.read()) != -1) {
        // If previous character is the whitespace and 
        // the current character is not, it will count the word.
        if (Character.isWhitespace(previousCharacter)) 
        { 
          if(!Character.isWhitespace(currentCharacter))
          wordCount++;
        }
        // Update the previous character.
        previousCharacter = currentCharacter;
           
      }// while
    }// try
    catch (IOException exception) {
      System.err.println(exception);
    }// catch
    finally {
      try { input.close(); }
      catch (IOException exception) {
        System.err.println("Could not close input " + exception); }
    }// finally

    System.out.println("The number of words was: " + wordCount);
  }// main
}// class WordCount
