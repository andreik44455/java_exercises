import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
// Program takes its input from standart input or a named file, and puts
// its output on standart output or a named file. It deletes one of the 
// fields on each line.
public class DeleteField {
  private static final String LINE_FORMAT
    = "%s%n";
  
  public static void main(String[] args) {
    BufferedReader input = null;
    PrintWriter output = null;
    // Check for too many args before opening files, in case wrong names.
    try {
      if (args.length > 3)
        throw new DeleteFieldException("Too many arguments");
      if (args.length < 2 || args[1].equals("-"))
        input = new BufferedReader(new InputStreamReader(System.in));
      else
        input = new BufferedReader(new FileReader(args[1]));
      
      if (args.length < 3 || args[2].equals("-"))
        output = new PrintWriter(System.out, true);
      else {
        if (new File(args[2]).exists())
          throw new LineNumberException("Output file " + args[2] + 
        		                        " already exists");
        output = new PrintWriter(new FileWriter(args[2]));  	  
      }// else
        
      String currentLine;
      // If current line is not null, edit it.
      while ((currentLine = input.readLine()) != null) {
    	// Split the line and put result in the array.
    	String[] fields = currentLine.split("\t");
    	String editedLine = "";
    	int fieldToDelete = Integer.parseInt(args[0]);
    	// Check if fields needs to be deleted.
    	if (fields.length < fieldToDelete)
    	  editedLine = currentLine;
    	else {
    	  // We build the new line in parts.
    	  // Add the fields before the one to be deleted.
    	  for (int index = 0; index < fieldToDelete - 1; index++)
    	    if (editedLine.equals("")) editedLine = fields[index];
    	    else                       editedLine += "\t" + fields[index];
    	  for (int index = fieldToDelete; index < fields.length; index++)
    	    if (editedLine.equals("")) editedLine = fields[index];
    	    else                       editedLine += "\t" + fields[index];
    	}// else
        output.printf(LINE_FORMAT, editedLine);
      }// while
    }// try
    catch (IOException exception) {
      System.err.println(exception);
    }// catch
    catch (DeleteFieldException exception) {
      System.out.println(exception.getMessage());
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
}// class DeleteField
