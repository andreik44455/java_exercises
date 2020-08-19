
public class MoodyGroup<PersonType extends MoodyPerson> {
  private static final int INITIAL_ARRAY_SIZE = 2, ARRAY_RESIZE_FACTOR = 2;
  private MoodyPerson[] persons = new MoodyPerson[INITIAL_ARRAY_SIZE];
  private int noOfPersons = 0;
  
  public MoodyGroup() {
	  
  }// MoodyGroup
  
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
  
  public int getSize() {
    return noOfPersons;
  }// getSize
  
  private int nextToSetHappy = 0;
  
  public void setHappy(boolean newHappiness) {
    if (noOfPersons > 0) {
      persons[nextToSetHappy].setHappy(newHappiness);
      nextToSetHappy = (nextToSetHappy + 1) % noOfPersons;
    }// if
  }// setHappy
  
  public String toString() {
    String result = noOfPersons == 0 ? "" : "" + persons[0];
    for (int index = 1; index < noOfPersons; index++)
      result += String.format("%n%s", persons[index]);
    return result;
  }// toString
}// class MoodyGroup
