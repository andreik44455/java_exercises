import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Uuencode {
  private static FileInputStream inputBytes;

  private static int numberOfBytes = 0;
  // Array to hold bytes for one line.
  private static int[] lineBytes = new int[45];  
  

  // Write a single result byte as a printable character.
  private static void writeByteAsChar(int thisByte) {
    System.out.print((char) (thisByte == 0 ? 96 : thisByte + 32));
  }// writeByteAsChar
  
  public static void main(String[] args) {
   
    // Header
    System.out.println("file mode 600");
    String filename = null;
    try {
      // Check we have 1 arguments.
      if (args.length != 1) {
        throw new IllegalArgumentException(); } 

      filename = args[0];
      inputBytes = new FileInputStream(filename);
      
      int  currentByte = inputBytes.read();
      // While next byte is not -1.
      while (currentByte != - 1) {
        numberOfBytes = 0;
        // While next byte is not -1 and array is not full.
        while ((currentByte != -1) && (numberOfBytes != lineBytes.length)) {

          // Put next byte in the array
          lineBytes[numberOfBytes] = currentByte;
          
          // Update the number of bytes.
          numberOfBytes++;
          // Store the next byte.
          currentByte = inputBytes.read();
          
        }// while
        
        writeByteAsChar(numberOfBytes);

        for (int byteGroupIndex = 0; byteGroupIndex < numberOfBytes; 
        		                                  byteGroupIndex+=3) {
          // Calculate 4 result bytes from 3 input bytes.
          int byte1 = lineBytes[byteGroupIndex] >> 2;
          int byte2 = (lineBytes[byteGroupIndex] & 0x3) << 4
                        | (lineBytes[byteGroupIndex + 1] >> 4);
          int byte3 = (lineBytes[byteGroupIndex + 1] & 0xf) << 2
                         | lineBytes[byteGroupIndex + 2] >> 6;
          int byte4 = lineBytes[byteGroupIndex + 2] & 0x3f;
                
          // Now write those result bytes.
          writeByteAsChar(byte1);
          writeByteAsChar(byte2);
          writeByteAsChar(byte3);
          writeByteAsChar(byte4);
        }// for
        System.out.println("");
      }// while

        System.out.println("`");
        System.out.println("end");
      if (inputBytes.read() != -1)
        throw new IOException("Data after end of text");
    }
    catch (IllegalArgumentException exception) {
      System.err.println("Please supply only 1 argument"); }
    catch (FileNotFoundException exception) {
      System.err.println("Cannot open byte file " + filename); }
    catch (IOException exception) {
    System.err.println("Problem reading byte file: "
                       + exception.getMessage());
    }// catch
    finally {
      try { if (inputBytes != null) inputBytes.close(); }
      catch (IOException exception)
        {  System.err.println("Could not close image file " + exception); }
    }// finally
  }// main  
}// class Uuencode
