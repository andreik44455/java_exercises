import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Program takes two command line argument, the name of the original file,
// and the sorted file to be created. It works by reading the lines from the
// input into an ArrayList of DeliveryHouseDetails. It compares house numbers
// by using Collections method sort and print the lines sorted.
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

      // Create an array of DeliveryHouseDetails
      List<DeliveryHouseDetails> lineList = new ArrayList<DeliveryHouseDetails>();
 
      // Keep track of house number
      int count = 1;
      String currentLine;
      while ((currentLine = input.readLine()) != null) {
        // Store new details in the ArrayList
    	DeliveryHouseDetails house = new DeliveryHouseDetails(count, currentLine);  
        lineList.add(house);
        // Increase house number by 1
    	count ++;
      }// while
      Collections.sort(lineList);
      // Print sorted ArrayList in the output file.
      for (int index = 0; index < lineList.size() - 1; index++)
          output.println(lineList.get(index).getPersonName());

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

