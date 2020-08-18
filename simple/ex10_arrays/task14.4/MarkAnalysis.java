 import java.util.Scanner;
/*Program to analyze student information supplied by the user. Each student
 * comprises a name and their score. Output is mean score and ascending
 * sorted list of students. There must be at least one student.
 */
public class MarkAnalysis {
  public static void main(String[] args)
  {
    //A scanner for getting data from the user.
    Scanner inputScanner = new Scanner(System.in);
  
    System.out.print("Enter the number of students: ");

    int numberOfStudents = inputScanner.nextInt();
    inputScanner.nextLine();
    //We keep the students in an array.
    Student[] students = new Student[numberOfStudents];
  
    //Read the data in pairs.
    //build Student objects and store them in students array.
    for (int index = 1; index <= numberOfStudents; index++) {   
      System.out.print("Enter the name of student " + index + ": ");
      String student = inputScanner.nextLine();
      System.out.print("Enter score for'" + student + "': ");
      int score = inputScanner.nextInt();
      //Skip past the end of that line
      inputScanner.nextLine();
      students[index-1] = new Student(student, score);
    }//for
    
    //Compute the mean of scores and find the maximum and minimum values.
    int sumOfScores = students[0].getScore();
    int x = 0;
    int maxScore = students[0].getScore();
    int minScore = students[0].getScore();
    for (int index=1; index < numberOfStudents; index++) {
      sumOfScores += students[index].getScore();
         
      x = students[index].getScore();
      if (x > maxScore)
        maxScore = x;
      
      if (x < minScore)
        minScore = x;
    }//for
    
    double meanScore = (int) sumOfScores / (double)numberOfStudents;
   
    //Sort the students by scores into ascending order.
    sort(students);
    
    //Produce the results.
    System.out.println();
    System.out.println("The mean mark is:\t " + meanScore);
    System.out.println("The minimum mark is:\t " + minScore);
    System.out.println("The maximum mark is:\t " + maxScore);
    System.out.println();
    
    System.out.println("Person and Score   | difference from mean");
    
    for (int index=0; index < numberOfStudents; index++) {
      double differenceFromMean = students[index].getScore() - meanScore;
      System.out.printf("%-10s got %3d |  %6.2f %n", 
    		  			students[index].getStudent(), students[index].getScore(), differenceFromMean);
    }//for  
  }//main
  
  //Sort the given array of students using compareTo on the Student objects.
  private static void sort(Student[] anArray)
  {
    //Each pass of the sort reduces unsortedLength by 1
  	int unsortedLength = anArray.length;
  	boolean changedOnThisPass;
  	do {
  	  changedOnThisPass = false;
  	  for (int pairLeftIndex = 0;
  		     pairLeftIndex < unsortedLength - 1; pairLeftIndex++)
  	    if (anArray[pairLeftIndex].compareTo(anArray[pairLeftIndex+1]) > 0 ) {
  	      Student thatWasPairLeftIndex = anArray[pairLeftIndex];
  	      anArray[pairLeftIndex] = anArray[pairLeftIndex +1];
  	      anArray[pairLeftIndex + 1] = thatWasPairLeftIndex;
  	      changedOnThisPass = true;
  	    }//if
  	  unsortedLength--;
  	} while (changedOnThisPass);
  }//sort
}//class MarkAnalysis
