import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map; 
//The program takes two command line arguments, the first being the name of the
//input file, the second being the name of the resulting report file.
//It detects and reports duplicate voter identification, followed by the number
//of duplicates found
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
      
      //The HashMap of all voters found so far.
      Map<String, String> voter = new HashMap<String,String>();
      //Keep count of the number of duplicates.
      int numberOfDuplicates = 0;
      String currentLine;
      //Value of the voter HashMap
      String value;
      //for saving the duplicate voter
      String duplicate;
      
      //Update currentLine with current line if there is any
      while ((currentLine = input.readLine()) != null) {
    	//Update value with time and location if there is any
    	if ((value = input.readLine()) != null) 
    	  //Check with a key if such key exist
    	  if ((duplicate = voter.get(currentLine)) != null) {
    		//if exist, then output it with previous value and the new one
    		//Update the number of duplicates
            numberOfDuplicates++;
    	    output.println(currentLine);
    	    output.println("  Duplicate: " + value);
    	    output.println("  First occurence: " + duplicate);
    	  }
    	  //else put key and value in the voter
    	  else voter.put(currentLine, value);
      }// while
      //Output the number of duplicates
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
