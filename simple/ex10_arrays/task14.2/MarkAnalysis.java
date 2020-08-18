import java.util.Scanner;

public class MarkAnalysis {
  public static void main(String[] args)
  {
    //A scanner for getting data from the user.
    Scanner scoresScanner = new Scanner(System.in);
  
    System.out.print("Enter the number of scores: ");

    int numberOfScores = scoresScanner.nextInt();
  
    //Scores are ints, stored in an array
    int[] scores = new int[numberOfScores];
  
    //obtain the scores from the array
    for (int index=0; index < numberOfScores; index++) {
      System.out.print("Enter score # " + (index+1) + ": ");
      scores[index] = scoresScanner.nextInt();
    }//for
    
    //Compute the mean of scores
    int sumOfScores = scores[0];
    int x = 0;
    int maxScore = scores[0];
    int minScore = scores[0];
    for (int index=1; index < numberOfScores; index++) {
      sumOfScores += scores[index];
      
      x = scores[index];
      if (x > maxScore)
        maxScore = x;
      
      if (x < minScore)
        minScore = x;
    }//for
    
    double meanScore = (int) sumOfScores / (double)numberOfScores;
   
    
    System.out.println();
    System.out.println("The mean mark is:\t " + meanScore);
    System.out.println("The minimum mark is:\t " + minScore);
    System.out.println("The maximum mark is:\t " + maxScore);
    System.out.println();
    
    System.out.println("Person | Score | difference from mean");
    
    for (int index=0; index < numberOfScores; index++) {
      double differenceFromMean = scores[index] - meanScore;
      System.out.printf("%6d | %5d |  %6.2f %n", (index+1),
                        scores[index], differenceFromMean);
    }//for
  }//main
}//class MarkAnalysis

