public class CalendarHighlight 
{
  public static void main (String [] args)
  {
    printMonth(Integer.parseInt(args[0]),Integer.parseInt(args[1]), Integer.parseInt(args[2]));       
  }//main 
  
  //print calendar for the month
  private static void printMonth(int monthStartDay, int lastDateInMonth, int signedDate)
  {
    //what is the next day (1-7) to print out
    int nextDayColumnToUse = monthStartDay;
    
    //next date to print out
    int nextDateToPrint = 1;
    
    //Top Line of hyphens
    printMonthLineOfHyphens();
    
    //The column headings
    printDayNames();
    
    //printing out the rows
    int noOfRows = 0;
    while (nextDateToPrint <= lastDateInMonth || noOfRows < 6)
    {
      //print one row
      System.out.print("| ");
      for (int dayColumnNo = 1; dayColumnNo <= 7; dayColumnNo++)
      {
        //space separator
        if (dayColumnNo > 1)
          if (nextDateToPrint == signedDate)
            System.out.print(" >");
          else 
            if (nextDateToPrint == signedDate+1)
                System.out.print("< ");
            else System.out.print("  ");
         
        //print space or date
        if (dayColumnNo != nextDayColumnToUse || nextDateToPrint > lastDateInMonth)
          printDateSpace();
        else 
        {
          printDate(nextDateToPrint);
          nextDayColumnToUse++;
          nextDateToPrint++;
        }//else                    
      }//for
      
      //End the row
      System.out.println(" |");
      noOfRows++;
      
      //reset the next day column
      nextDayColumnToUse = 1;      
    }//while
    
    //The bottom line of hyphens
    printMonthLineOfHyphens();
  }//printMonth
  
  //line of hyphens
  private static void printMonthLineOfHyphens()
  {
    System.out.print(" -");
    for (int dayColumnNo = 1; dayColumnNo <=7; dayColumnNo++)
    {
      if (dayColumnNo>1)
        System.out.print("--");
      printDateHyphens();      
    }//for
    System.out.println("- ");        
  }//printMonthLineOfHyphens
  
  //day name headings
  private static void printDayNames()
  {
    System.out.print("| ");
    for (int dayColumnNo = 1; dayColumnNo <=7; dayColumnNo++)
    {
      if (dayColumnNo>1) 
        System.out.print("  ");
      printDayName(dayColumnNo);            
    }//for
    System.out.println(" |");
  }//printDayNames
  
  //day name
  private static void printDayName(int dayNo)
  {
    switch (dayNo)
    {
      case 1: System.out.print("Su"); break;
      case 2: System.out.print("Mo"); break;
      case 3: System.out.print("Tu"); break;
      case 4: System.out.print("We"); break;
      case 5: System.out.print("Th"); break;
      case 6: System.out.print("Fr"); break;
      case 7: System.out.print("Sa"); break;
    }//switch
  }//printDayName
  
  //print spaces as wide as date
  private static void printDateSpace()
  {
    System.out.print("  ");
  }//printDateSpace
  
  //print hyphens
  private static void printDateHyphens()
  {
    System.out.print("--");
  }//printDateHyphens
  
  private static void printDate(int date)
  {
    System.out.printf("%02d", date);
  }//printDate
  
}//class CalendarHighlight


