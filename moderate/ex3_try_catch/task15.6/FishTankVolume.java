// This class finds the volume of the fish tank
// by  supplying 3 dimensions of it.
public class FishTankVolume {
  public static void main(String[] args) {
    try {
      int width = Integer.parseInt(args[0]);
      int depth = Integer.parseInt(args[0]);
      int height = Integer.parseInt(args[0]);
      // Check that length is appropriate.
      if (args.length > 3) {
        throw new ArrayIndexOutOfBoundsException
                    ("You have supplied " + args.length + " arguments!");
      }// if
      
      // Check that width, depth and height are appropriate.
      if (width <= 0 || depth <= 0 || height <= 0) {
        throw new NumberFormatException
                    ("One of your dimensions is negative or equals to zero!");
      } // if
      
      int volume = width * depth * height;
      System.out.println("The volume of a tank with dimensions "
                           + "(" + width + "," + depth + "," + height + ") "
                          + "is " + volume);
    }// try
    catch (ArrayIndexOutOfBoundsException exception) {
      System.out.println("Please supply dimensions of the tank"
                           + " and nothing else.");
      System.err.println(exception);
    }// catch
    catch (NumberFormatException exception) {
      System.out.println("You dimensions must be a positive whole numbers.");
      System.out.println("Exception message was: '" +
                         exception.getMessage() + "'");
      System.err.println(exception);
    }// catch
    catch (Exception exception) {
        System.out.println("Something unforeseen happened. :-( ");
        System.out.println("Exception message was: '" +
                           exception.getMessage() + "'");
        System.err.println(exception);
      }// catch
  }// main
}// FishTankVolume class

