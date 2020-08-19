import java.awt.Color;

/*
 * A kind of moody person.
 */

public class MagicWorker extends Worker
{
  //variable for image of the magic worker
  private final PersonImage image1;
  
  //initial size and resize factor for the array
  private static final int INITIAL_ARRAY_SIZE = 10;
  private static final int ARRAY_RESIZE_FACTOR = 2;
  private int noOfBallsInArray = 0;
  
  //make instance of the MagicBall array
  private MagicBall [] ballArray = new MagicBall[INITIAL_ARRAY_SIZE];

  // Constructor is given the person's name.
  public MagicWorker(String name)
  {
    super(name);
    image1 = makeImage();
  }  // MagicWorker


  // Returns the name of the type of Person.
  public String getPersonType()
  {
    return "Magic Worker";
  } // getPersonType

  //overrides the makeImage() method of the Person class
  //returns a refernce to magic worker image
  public PersonImage makeImage() {
    return new MagicWorkerImage(this);
  }//makeImage

  //This causes the doMagic() method of every magic ball made by 
  //this worker, to be invoked with the same spellNumber as given here.
  public void doMagic(int spellNumber) {
     for (int index=0; index<ballArray.length; index++)
       ballArray[index].doMagic(spellNumber);
  }//doMagic


  // Returns a newly created MagicBall with the given number and colour.
  public Ball makeNewBall(int number, Color colour)
  {
    //keep track of all the balls he or she has ever made, 
    //by storing a reference to them in an array.
    if (noOfBallsInArray == ballArray.length) {
      MagicBall [] biggerArray = new MagicBall[ballArray.length * 
                                               ARRAY_RESIZE_FACTOR];
      for (int index = 0; index < noOfBallsInArray; index++)
        biggerArray[index] = ballArray[index];
      ballArray = biggerArray;
    }//if
    MagicBall ball = new MagicBall(number, colour);
    ballArray[noOfBallsInArray] = ball;
    noOfBallsInArray++;
    return ball;
  } // makeNewBall


  //Returns person's class hierarchy
  public String getClassHierarchy() {
    return "MagicWorker>" + super.getClassHierarchy();
  }//getClassHierarchy

} // class Worker
