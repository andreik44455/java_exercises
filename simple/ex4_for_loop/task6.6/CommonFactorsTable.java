public class CommonFactorsTable
{
  public static void main(String[] args)
  {
    //Top line
    System.out.print("|-----|");

    //Above the column heading
    for (int column=2; column <= 20; column++)
      System.out.print("---");

    System.out.println("-|");  
    
    //Column heading
    System.out.print("|     |");
    for (int column = 2; column <= 20; column++)
     if (column < 10)
      System.out.print("  " + column);
     else
      System.out.print(" " + column);
    System.out.println(" |");

    //Under the column heading
    System.out.print("|-----|");
    for (int column=2; column <= 20; column++)
     System.out.print("---");

    System.out.println("-|");
    
    int rowCopy;
    int columnCopy;
    //The rows
    for (int row = 2; row <=20; row++)
    { 
     
      if (row < 10)
        System.out.print("|   " + row + " |");
      else 
        System.out.print("|  " + row + " |");
      //for column
      for (int column = 2; column <= 20; column++) {
        rowCopy = row;
        columnCopy = column;
        while (rowCopy != columnCopy)
          if (rowCopy > columnCopy)
            rowCopy -= columnCopy;
          else
            columnCopy -= rowCopy;

        if (rowCopy != 1)
          System.out.print("--#");
        else
          System.out.print("--|");
        }//for column
      System.out.println(" |");
    }// for rows

    //Bottom line
    System.out.print("|-----|");

    for (int column = 2; column <= 20; column++)
      System.out.print("---");

    System.out.println("-|");  
  }//main
}//class CommonFactorsTable
