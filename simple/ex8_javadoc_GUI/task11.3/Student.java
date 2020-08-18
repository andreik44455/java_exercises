public class Student 
{
  //student has a name which cannot be changed
  private final String studentName;
  
  //phone that student currently has or null if no
  private Phone currentPhone = null;

  //Student constructor
  public Student(String requiredStudentName)
  {
    studentName = requiredStudentName;
  }
  
  public String getStudentName()
  {
    return studentName;
  }//getStudentName
	  
  public void buyPhone(Phone other)
  {
    currentPhone = other;
  }//buyPhone

  public Phone getCurrentPhone()
  {
    return currentPhone;
  }//getCurrentPhone
  
  public boolean comp(int seconds)
  {
    return currentPhone.compare(seconds);
  }//comp

  public void tryToCall(int seconds)
  { 
    if (currentPhone == null)
      return;
    currentPhone.acceptCall(seconds);
  }//tryToCall
	  
  public void tryToTopUp(int pounds)
  {
	if (currentPhone == null)
	  return;
    currentPhone.toppingUp(pounds);
  }//tryToTopUp

  public String toString()
  {
    return  "Student(" + studentName +  ", " + currentPhone + ") " ;
  }//toString
}//class Student
