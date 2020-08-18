//A class for representing a student.
//comprising a student's name and their score.
public class Student {
  //the name of the student
  private final String student;
  
  //A given score.
  private final int score;
  
  //The constructor method.
  public Student(String requiredStudent, int requiredScore)
  {
    student = requiredStudent;
    score = requiredScore;
  }// Student
  
  //Get student.
  public String getStudent()
  {
    return student;
  }//getStudent
  
  public int getScore()
  {
    return score;
  }//getScore
  
  //Compare this Student with a given other,
  //basing the comparison on the scores, then students
  //instead.
  public int compareTo(Student other)
  {
    if (score == other.score)
      return student.compareTo(other.student);
    else
      return score - other.score;
  }//compareTo
  

  
}//class Student
