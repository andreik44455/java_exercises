import java.io.IOException;
// Program reads all the bytes from standart input and
// outputs a single number on standart output.
public class CheckSum {
  public static void main (String[] args) {
    // Variable for sum of bytes
    int checkSum = 0;
    try {
      int currentByte;
      while ((currentByte = System.in.read()) != -1) {
        if ((checkSum % 2) == 0)
          checkSum /= 2;
        else {
          checkSum /= 2;
          checkSum += 32768;
        }// else 
        checkSum += currentByte;
        if (checkSum >= 65536)
          checkSum -= 65536;
      }// while
    }// try
    catch (IOException exception) {
      System.err.println(exception);
    }// catch
    finally {
      try { System.in.close(); }
      catch (IOException exception) {
        System.err.println("Could not close input " + exception); }
    }// finally
    System.out.println(checkSum);    
  }// main
}// class Check Sum
