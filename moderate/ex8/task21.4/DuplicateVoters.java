import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;
//The program takes two command line arguments, the first being the name of the
//input file, the second being the name of the resulting report file.
//It detects and reports duplicate voter identification, followed by the number
//of duplicates found.
public class DuplicateVoters {
	
  public static void main(String[] args) {
	//Initialize input and output
    BufferedReader input = null;
    PrintWriter output = null;
    
    try {
      //If there is no 2 arguments - throw exception
      if (args.length != 2)
        throw new IllegalArgumentException
                    ("There must be exactly two arguments: infile outfile");
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
      
      //The set of all voters found so far.
      Set<String> voters = new HashSet<String>();
      //Keep count of the number of duplicates.
      int numberOfDuplicates = 0;
      String currentLine;
      //Keep count of the number of lines.
      int count = 1;
      //While there is a line
      while ((currentLine = input.readLine()) != null) {
    	//Check if it is an odd line
        if (count % 2 !=0) {
          //Add voter to the set
          //If such voter already in the set
    	  if (!voters.add(currentLine)) {
    		//Update number of duplicates
            numberOfDuplicates++;
            //Output a duplicate
            output.println(currentLine);
    	  }// if
    	}// if
        count ++;
      }// while
      output.println("There were " + numberOfDuplicates + " duplicate votes");
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
      }// if
    }// finally
  }// main
}// class DuplicateVoters

