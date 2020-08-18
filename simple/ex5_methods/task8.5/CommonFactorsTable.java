
public class CommonFactorsTable
{ 
private static int tableSize = 20;

  public static void main(String args[])
  {
    //top line
    printLine();
           
    //column headings
    printColumnHeadings();
           
    //Underline Headings
    printLine();
           
    //rows
    for (int row = 2; row <= tableSize; row++)
      printRow(row);
    //Bottom line
    printLine();
  }//main
       
       
  //Line
  private static void printLine()
  {
    System.out.print("|-----|");
          
    for (int column = 2; column <= tableSize; column++)
      System.out.print("---");
          
    System.out.println("-|");
  }//printLine
       
       
  //column headings
  private static void printColumnHeadings()
  {
    System.out.print("|     |");
    for (int column = 2; column <= tableSize; column++)
      if (column<10)
        System.out.print("  " + column);
      else 
        System.out.print(" " + column);
          
    System.out.println(" |");
  }//printColumnHeadings
          
       
  //number of spaces
  private static void printNumber (int n)
  {
    if (n<10)
      System.out.print("   " + n);
    else if (n<100)
      System.out.print("  " + n);
    else
      System.out.print(" " + n);
  }//printNumber
       
       
  //Rows
  private static void printRow(int row)
  {
    System.out.print("|");
    printNumber(row);
    System.out.print(" |");
           
           
    for (int column = 2; column <= tableSize; column++) { 
      int columncount=column;
      int rowcount=row;
      while (columncount != rowcount)
        if (columncount > rowcount)
          columncount-=rowcount;
        else rowcount-=columncount;
                      
        if (rowcount == 1)
          System.out.print("--|");
        else System.out.print("--#");           
    }//for     
                 
    System.out.println(" |");
  }//printRow

}//CommonFactorsTable

