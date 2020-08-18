public class TruthTable34 
{
   //methods for propositinal expressions p1, p2, p3
   private static boolean p1(boolean a, boolean b, boolean c, boolean d)
   {   
      return (((a || b) && c) || ((b || c) && d)) && (a || d);
   }//p1

   private static boolean p2(boolean a, boolean b, boolean c, boolean d)
   {
      return a && c || b && d || c && d;
   }//p2

   private static boolean p3(boolean a, boolean b, boolean c, boolean d)
   {
      return (b || c) && (c || d) && (a || d);
   }//p3
  
   //line on the top of the truth table   
   private static void printStraightLine()
   {
      System.out.println("________________________________________________________");
   }//printStraightLine
   
   //heading for the truth table
   private static void printHeadings()
   {
      System.out.println("|   a   |   b   |   c   |   d   |  p1   |  p2   |  p3   |");
   }//printHeadings
   
   //print under heading line
   private static void printColumnLine()
   {
      System.out.println("|_______|_______|_______|_______|_______|_______|_______|");
   }//printColumnLine
   
   //printing  the rows
   private static void printRow(boolean a, boolean b, boolean c , boolean d)
   {
      System.out.println("|" + formatRowItem(a) + "|" + formatRowItem(b) + "|" 
                      + formatRowItem(c) + "|" + formatRowItem(d) + "|" + 
                      formatRowItem(p1(a, b, c, d)) + "|"
                      + formatRowItem(p2(a, b, c, d)) + "|"
                      + formatRowItem(p3(a, b, c, d)) + "|");
   }//printRow
    
   //row items
   private static String formatRowItem(boolean rowItem)
   {
      return rowItem ? " true  " : " false ";
   }//rowItem
   
   public static void main(String [] args)
   {
      printStraightLine();
      printHeadings();
      printColumnLine();
      boolean a = true, b = true, c = true, d = true;
   
      for (int countA = 1; countA <=2; countA++, a = !a)
         for (int countB = 1; countB <=2; countB++, b = !b)
            for (int countC = 1; countC <=2; countC++, c = !c)
               for (int countD = 1; countD <=2; countD++, d = !d)
                printRow(a, b, c, d);

   printColumnLine();
   }//main 
} // class TruthTable34

