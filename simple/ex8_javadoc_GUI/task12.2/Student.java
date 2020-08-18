/**
 * This class represents students and provides certain manipulations of them. 
 *
 *
 * @author Andrei Korovin
 */
public class Student 
{
  //student has a name which cannot be changed
  private final String studentName;
  
  //phone that student currently has or null if no
  private Phone currentPhone = null;

  /**
   *Construct a student.
   *
   *@param requiredStudentName The required student name.
   */
  public Student(String requiredStudentName)
  {
    studentName = requiredStudentName;
  }//Student
  
  /**
   *Get the student name.
   *
   *@return The student name.
   */
  public String getStudentName()
  {
    return studentName;
  }//getStudentName
  
  /**
   *Buy a phone.
   *
   *@param other The other phone that was bought.
   *
   */	  
  public void buyPhone(Phone other)
  {
    currentPhone = other;
  }//buyPhone

  /**
   *Get the current phone.
   *
   *@return the current phone or null if it was not bought.
   */
  public Phone getCurrentPhone()
  {
    return currentPhone;
  }//getCurrentPhone
  
  /**
   *Get the boolean result from Phone class.
   *If desired amount of seconds more than balance then it will return true,
   * otherwise false.
   *
   *@param seconds The desired amount of seconds of the phone call.
   *@return true or false
   */
  public boolean comp(int seconds)
  {
    return currentPhone.compare(seconds);
  }//comp

  /**
   *If the current phone is not null, it will call the acceptCall instance 
   *method from Phone class. It changes the the total number of seconds
   *called on the phone and balance in the account.
   *
   *@param seconds The desired amount of seconds of the phone call.
   */
  public void tryToCall(int seconds)
  { 
    if (currentPhone == null)
      return;
    currentPhone.acceptCall(seconds);
  }//tryToCall
  
  /**
   *If the current phone is not null, it will call the toppingUp instance
   *method from Phone class. It tops up the account balance.
   *
   *@param pounds The pounds to top up an account
   */
  public void tryToTopUp(int pounds)
  {
	if (currentPhone == null)
	  return;
    currentPhone.toppingUp(pounds);
  }//tryToTopUp
  
  /**
   *Provides student's name, the current phone with total number of seconds
   *called and balance on the account.
   *
   *@return A string Student(student name, Phone(phone name and model,
   *total number of seconds, Account(provider name, balance))) 
   */
  public String toString()
  {
    return  "Student(" + studentName +  ", " + currentPhone + ") " ;
  }//toString
}//class Student
