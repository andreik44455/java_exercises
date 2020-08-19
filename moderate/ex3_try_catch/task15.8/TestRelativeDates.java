public class TestRelativeDates {
  public static void main(String[] args) throws Exception{
    Date myDate = new Date(31, 12, 2016);
    int count = 1;
    do {
      System.out.println("Current date: " + myDate);
      System.out.println("Day added: " + myDate.addDay());
      System.out.println("Month added: " + myDate.addMonth());
      System.out.println("Year added: " + myDate.addYear());
      System.out.println("Day subtructed " + myDate.subtractDay());
      System.out.println("Month subtructed " + myDate.subtractMonth());
      System.out.println("Year subtructed " + myDate.subtractYear());

      
      System.out.println(" --------------- ");
      System.out.println(" --------------- ");

      myDate = myDate.addDay();
 
      count++;
     } while (count < 720);
  }
}
