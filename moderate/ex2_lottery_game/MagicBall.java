import java.awt.Color;
 
public class MagicBall extends Ball {
   
  //4 different states of the magic ball
  public static final int NORMAL = 0;
  public static final int INVINSIBLE = 1;
  public static final int FLASHING = 2;
  public static final int COUNTING = 3;
 
  //variable to store the current state of the ball
  private int currentState; 
  
  //An additional instance variable to store the last value returned 
  //by getValue()
  private int storedValue = super.getValue();

  //instance variable to make the image of the magic ball
  private BallImage image1 = super.getImage();
  
  //constructor
  public MagicBall(int requiredValue, Color requiredColour) {
    super(requiredValue, requiredColour);
    currentState = MagicBall.NORMAL;
  }//MagicBall

  //Returns instance of the MagicBall image.
  public BallImage makeImage() {
    return new MagicBallImage(this);
  }//makeImage()

  //Returns the value of the ball and overrides supeclass's method
  public int getValue(){
    if (currentState == COUNTING)
    {
      //The value appears to count from 0 to 99 and round again
      if (storedValue == 99)
        storedValue = 0;
      else storedValue++;
      return storedValue;
    }//if
    else return super.getValue();
  }//getValue

  public void doMagic(int spellNumber) {
    //make the state of the magic ball change to the next state
    if (spellNumber == 1)
    {
      // going back to the first state after the last
      if (currentState == COUNTING)
         currentState = NORMAL;
      else currentState++;
      image1.update();
    }//if
    // make  the  state of  the  magic ball change to its normal state.
    else if (spellNumber == 2) {
      currentState = NORMAL;
      image1.update();
    }
    else if (spellNumber == 3) {

    }
  }//doMagic
  
  //Returns true if  the  magic  ball  is  in  a  state 
  //which requires the image to be visible, false otherwise.
  public boolean isVisible() {
    if (currentState != INVINSIBLE)
    {
      return true;
    }//if
    else
    { 
      return false;
    }//else
  }//isVisible

  //Returns true if  the  magic  ball  is  in  a  state
  //which requires the image to flash, false otherwise.  
  public boolean isFlashing() {
    if (currentState == FLASHING || currentState == COUNTING)
    { 
      return true;
    }//if
    else return false;
  }//isFlashing
}//class Magicall
