import java.awt.Color;

/*
 * A kind of moody person.
 */

public class Worker extends MoodyPerson
{
  // Constructor is given the person's name.
  public Worker(String name)
  {
    super(name);
  }  // Worker


  // Returns the name of the type of Person.
  public String getPersonType()
  {
    return "Worker";
  } // getPersonType


  // Returns the Person's colour.
  public Color getColour()
  {
    return Color.lightGray;
  } // getColour


  // Returns the Person's current saying.
  public String getCurrentSaying()
  {
    if (isHappy())
      return "Time for tea, I think";
    else
      return "Puff, pant, puff, pant";
  } // getCurrentSaying







  //
  public String getClassHierarchy() {
    return "Worker>" + super.getClassHierarchy();
  }//getClassHierarchy

} // class Worker
