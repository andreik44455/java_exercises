import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
//The program takes two command line arguments, the first being the name of the
//input file, the second being the name of the resulting report file.
public class ReverseLines {
  
  //Method to output line in reverse order
  public static void recurciveLines(BufferedReader input, PrintWriter output)
                                                           throws Exception {
  	String headLine;
  	//If input line is not empty
  	if ((headLine = input.readLine()) != null) {
  	  //Recursively output the last line
  	  recurciveLines(input, output);
  	  //Output the first line
  	  System.out.println(headLine);
    }// if
  }// recurciveLines
  
  public static void main(String[] args) {
	//Initialize input and output
    BufferedReader input = null;
    PrintWriter output = null;
    
    try {

      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(System.out, true);
      //Call the method and parse input output
      recurciveLines(input, output);
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
}// class StreetOrder
