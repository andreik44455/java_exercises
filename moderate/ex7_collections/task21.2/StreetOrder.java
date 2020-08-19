import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Program takes two command line argument, the name of the original file,
// and the sorted file to be created. It works by reading the lines from the
// input into an ArrayList of Strings. It loops forwards through all the even
// indices of the list, printing the lines to the output file. Then it loop
// backwards through the odd indices of the list and print those lines.
public class StreetOrder {
  public static void main(String[] args) {
    BufferedReader input = null;
    PrintWriter output = null;
    
    try {
      if (args.length != 2)
        throw new IllegalArgumentException
                    ("There must be exactly two arguments: infile outfile");
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
      
      List<String> lineList = new ArrayList<String>();
      
      String currentLine;
      // Read lines while they exist.
      while ((currentLine = input.readLine()) != null)
        lineList.add(currentLine);
      // Loop forwards through even numbers
      for (int index = 0; index < lineList.size() - 1; index++)
        if (index % 2 == 0 )
          // print them
          output.println(lineList.get(index));
      // Loop backwards through odd numbers
      for (int index = lineList.size() - 1; index >= 0 ; index--)
      { 
        // Check if the number of lines is odd and print missing line.
        if (lineList.size() % 2 != 0)
    	  if (index == lineList.size() - 1)
            output.println(lineList.get(index)); 
        // print odd numbers.
        if (index % 2 != 0 )
          output.println(lineList.get(index));
      }// for
    }// try
    catch (Exception exception) {
      System.err.println(exception);
    }// catch

    finally {
      try { if (input != null) input.close(); }
      catch (IOException exception) {
        System.err.println("Could not close input " + exception); }
      if (output != null) {
        output.close();
        if (output.checkError())
          System.err.println("Something went wrong with output");
      } // if
    } // finally

  } // main
} // class StreetOrder

