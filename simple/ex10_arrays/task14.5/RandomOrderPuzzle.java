import java.util.Scanner;
import java.io.File;

public class RandomOrderPuzzle
{
  private int numberOfLines;
 
  private String[] linesInOriginalOrder;
 
  private final String[] linesSorted;
  
  private boolean sorted;


  //constructor method
  public RandomOrderPuzzle(Scanner scanner)
  {
    readLinesOriginalOrder(scanner);
    linesSorted = copyPuzzleArray(linesInOriginalOrder, numberOfLines);
    randomizeStringArrayOrder(linesSorted);
  }//RandomOrderPuzzle


  public static void main(String[] args) throws Exception
  {
  	Scanner fileScanner = new Scanner(new File(args[0]));
  	RandomOrderPuzzle puzzle = new RandomOrderPuzzle(fileScanner);
      
  	Scanner inputScanner = new Scanner(System.in);
  	System.out.println(puzzle);

  	int moveCount = 0;  
  	while (!puzzle.isSorted()) {
    	System.out.print("Enter a line number to with the last one: ");
    	puzzle.swapLine(inputScanner.nextInt());
    	System.out.println(puzzle);
    	moveCount++;
  	}//while

  	System.out.println("Game is over in " + moveCount + " moves.");
  }//main
 
  private static final int INITIAL_ARRAY_SIZE = 2;

  private static final int ARRAY_RESIZE_FACTOR = 2;

  private void readLinesOriginalOrder(Scanner scanner)
  {
  	linesInOriginalOrder = new String[INITIAL_ARRAY_SIZE];
  	numberOfLines = 0;
  	while (scanner.hasNextLine()) {
    	//Obtain the next Line.
    	String currentLine = readOneLine(scanner);
    	//Extend the array if it is too small.
    	if (numberOfLines == linesInOriginalOrder.length) {
      	String[] biggerArray
           	= new String[linesInOriginalOrder.length * ARRAY_RESIZE_FACTOR];
      	for (int index = 0; index < linesInOriginalOrder.length; index++)
        	biggerArray[index] = linesInOriginalOrder[index];
      	linesInOriginalOrder = biggerArray;
    	}//if
    	//Finally store the Line and update number of lines.
    	linesInOriginalOrder[numberOfLines] = currentLine;
    	numberOfLines++;
  	}//while
  }//readLinesOriginalOrder
 
  private String readOneLine(Scanner scanner)
  {
  	String[] lineData = scanner.nextLine().split("\n");
  	return new String(lineData[0]);
  }//readOneLine


  //Return a shallow copy of given source,
  //but only the first datalength elements.
  private String[] copyPuzzleArray(String[] source, int dataLength)
  {
  	String[] result = new String[dataLength];
  	for (int index = 0; index < dataLength; index++)
    	result[index] = source[index];
  	return result;
  }//copyPuzzleArray

  private boolean isSorted()
  {
  	for (int index = 0; index < linesSorted.length; index++) {
  	  if (linesSorted[index] == linesInOriginalOrder[index])
  	    sorted = true;
  	  else {
  	    sorted = false;
  	    break;
  	  }//else
  	}
  	return sorted;
  }//isSorted
  
  private void swapLine(int lineNumber)
  {
  	String lastElement = linesSorted[linesSorted.length-1];
  	linesSorted[linesSorted.length-1] = linesSorted[lineNumber];
  	linesSorted[lineNumber] = lastElement;
  	return;
  }//swapLine 


  private void randomizeStringArrayOrder(String[] anArray)
  {
  	for (int itemsRemaining = anArray.length;
         itemsRemaining > 0; itemsRemaining--) {
    	int anIndex = (int) (Math.random() * itemsRemaining);
    	String itemAtAnIndex = anArray[anIndex];
    	anArray[anIndex] = anArray[anArray.length -1];
    	anArray[anArray.length-1] = itemAtAnIndex;
  	}//for
  }//randomizeStringArrayOrder
  
  public String toString()
  {
  	String line = "";
    for (int index=0; index < linesSorted.length; index++)
      line +=index + " " + linesSorted[index] + "\n";
    return line;
  }//toString
  
}//class RandomOrderPuzzle

