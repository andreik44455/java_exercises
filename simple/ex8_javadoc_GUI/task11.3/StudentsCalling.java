public class StudentsCalling
{
  //private helper method to create a student
  private static void create(Student student)
  {
    System.out.println("Creating Student " + student);
    System.out.println("Result:");
    System.out.println(student);
    System.out.println();
  }//create
  
  //private helper method to buy a phone
  private static void buy(Student student, Phone phone)
  {
    if (student.getCurrentPhone() != null)
      System.out.println("Now let us discard a phone.");
    System.out.println(student);
    System.out.println("is buying " + phone.getPhone());
    System.out.println("with account " + phone.AccountName());
    student.buyPhone(phone);
    System.out.println("Result:");
    System.out.println(student);
    System.out.println();
  }//buy
    
  //private helper method to top up an account
  private static void topUp(Student student, int pounds)
  {
    if (student.getCurrentPhone()==null)
      System.out.println("This next top up has no effect, as has no Phone!"); 
    System.out.println(student);
    System.out.println("is topping up by " + pounds);
    student.tryToTopUp(pounds);
    System.out.println("Result:");
    System.out.println(student);
    System.out.println();
  }//topUp
  
  //private helper method to call
  private static void call(Student student, int seconds)
  {
	if (student.getCurrentPhone()==null)
	{
	  System.out.println("This next call has no effect, as has no Phone!");
	  System.out.println(student);
	  System.out.println("is making call for desired "
                             + seconds + " seconds");
	  student.tryToCall(seconds);
	  System.out.println("Result:");
	  System.out.println(student);
	  System.out.println();
	}//if
	else 
	  if (student.comp(seconds)==true)
	  {
	    System.out.println("This next call should be truncated.");
            System.out.println(student);
	    System.out.println("is making call for desired " + seconds
                               + " seconds");
	    student.tryToCall(seconds);
	    System.out.println("Result:");
	    System.out.println(student);
	    System.out.println();
	  }//if
	  else 
	  {
	    System.out.println(student);
	    System.out.println("is making call for desired " + seconds
                               + " seconds");
	    student.tryToCall(seconds);
	    System.out.println("Result:");
	    System.out.println(student);
	    System.out.println();
	  }//else
	
  }//call
  
  public static void main (String[] args)
  {
    System.out.println("Students calling: ");
    
    //create students
    Student student1 = new Student("Andrei Korovin");
    create(student1);
        
    Student student2 = new Student("Vitalik Khailov");
    create(student2);
    
    Student student3 = new Student("Kate Sidel");
    create(student3);
    
    Student student4 = new Student("Anna Kaptilina");
    create(student4);
    
    //call and top up without phones
    call(student1,500);
    topUp(student3, 5);
    
    //create phones with accounts
    Account account1, account2, account3, account4, account5;
    Phone phone1 = new Phone("Sony","X", account1 = new Account("Earth34") );
    Phone phone2 = new Phone("Samsung","S", account2 = new Account("Beeline"));
    Phone phone3 = new Phone("Nokia","3310", account3 = new Account("O2"));
    Phone phone4 = new Phone("Iphone","X", account4 = new Account("Mega"));
    //buy phones
    buy(student1,phone1);
    buy(student2,phone2);
    buy(student3,phone3);
    buy(student4,phone4);
    
    //top up
    topUp(student1, 20);
    topUp(student2, 10);
    topUp(student3, 5);
    topUp(student3, 30);
    
    //call
    call(student1,2500);
    call(student2,300);
    call(student3,1100);
    call(student3,1100);
    
    
    Phone phone5 = new Phone("Nokia","3310", account4 = new Account("O2"));
    buy(student1,phone5);
  }//main
}//class StudentCalling

