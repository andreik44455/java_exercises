import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeSet;

//Program takes two command line argument, the name of the original file,
//and the sorted file to be created. It works by reading the lines from the
//input into an TreeSet of Strings.
public class StreetOrder {
	
  public static void main(String[] args) {
    //Initialize input and output
    BufferedReader input = null;
    PrintWriter output = null;
    
    try {
      if (args.length != 2)
        throw new IllegalArgumentException
                    ("There must be exactly two arguments: infile outfile");
      
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
      
      //The TreeSet of all voters found so far.
      TreeSet<DeliveryHouseDetails> lineSet = new TreeSet<DeliveryHouseDetails>();
      
      String currentLine;
      int count = 1;
      //While there is a line in the input
      while ((currentLine = input.readLine()) != null) {
    	//Create a house object
    	DeliveryHouseDetails house = new DeliveryHouseDetails(count, currentLine);
    	//Add this object to the TreeSet
        lineSet.add(house);
        count++;
      }// while
      
      //Define iterator.
      Iterator<DeliveryHouseDetails> iterator = lineSet.iterator();
      //Accessing elements
      while (iterator.hasNext())
        output.println(iterator.next().getPersonName());
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
