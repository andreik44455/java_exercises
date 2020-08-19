// Representing of a group of lettery people changing mood in turn.
public class MoodyGroup<PersonType extends MoodyPerson> {
  // Initial size and resize factor.
  private static final int INITIAL_ARRAY_SIZE = 2, ARRAY_RESIZE_FACTOR = 2;

  // The array, together with the number of MoodyPerson objects in it.
  private MoodyPerson[] persons = new MoodyPerson[INITIAL_ARRAY_SIZE];
  private int noOfPersons = 0;
  
  // Empty constructor, nothing needs doing.
  public MoodyGroup() {
	  
  }// MoodyGroup
  
  // Add given MoodyPerson to the MoodyGroup (extend array as required).
  public void addPerson(PersonType newPerson) {
    if (noOfPersons == persons.length) {
      MoodyPerson[] biggerArray = new MoodyPerson[persons.length
                                                  * INITIAL_ARRAY_SIZE];
      for (int index = 0; index < persons.length; index++)
        biggerArray[index] = persons[index];
      persons = biggerArray;
    }// if
    persons[noOfPersons] = newPerson;
    noOfPersons++;
  }// addPerson
  
  // Return the number of people in the MoodyGroup.
  public int getSize() {
    return noOfPersons;
  }// getSize
  
  // Use to keep track of whos turn it is to change mood.
  private int nextToSetHappy = 0;
  
  // Make the next person to change mood and update who is next after that.
  public void setHappy(boolean newHappiness) {
    if (noOfPersons > 0) {
      persons[nextToSetHappy].setHappy(newHappiness);
      nextToSetHappy = (nextToSetHappy + 1) % noOfPersons;
    }// if
  }// setHappy
  
  // Mainly for testing.
  @Override
  public String toString() {
    String result = noOfPersons == 0 ? "" : "" + persons[0];
    for (int index = 1; index < noOfPersons; index++)
      result += String.format("%n%s", persons[index]);
    return result;
  }// toString
}// class MoodyGroup
