public class Phone
{
  //phone has a name and a model, and an account (both fixed)	
  private final String phoneName, model;  
  private Account accountName;
  //Total number of seconds during phone calls
  private int numberOfSeconds = 0;

  //Phone constructor
  public Phone(String requiredPhoneName, String requiredModel,
               Account requiredAccountName)
  {
    phoneName = requiredPhoneName;
    model = requiredModel;
    accountName =  requiredAccountName;
  }
  
  //get the Account object  
  public Account getAccountName()
  {
    return accountName;
  }//getAccountName

  //get the provider name of an account
  public String AccountName()
  {
    return accountName.getProviderName();
  }//AccountName

  //get phone's Name and Model
  public String getPhone()
  {
    return phoneName + " " + model;
  }//getPhone

  //get balance on the account
  public int getBalance()
  {
    return accountName.getAccountBalance();
  }//getBalance

  //calls method from the Account class so balance in the account is toped up
  public void toppingUp(int pounds)
  {
    accountName.acceptTopUp(pounds);
  }//toppingUp

  //accept call and call minusBalance method so balance in the account
  public int acceptCall(int sec)
  {
    int secCalled = sec;
    int balance = accountName.getAccountBalance();
    if (secCalled > balance)
      secCalled = balance;
	    
    numberOfSeconds +=secCalled;
    accountName.minusBalance(numberOfSeconds);
    return secCalled;
  }//acceptCall
  
  public boolean compare(int sec)
  {
    int secCalled = sec;
    int balance = accountName.getAccountBalance();
    if (secCalled > balance)
	 return true;
               
    else return false;
  }//compare

  public String toString()
  {
    return "Phone(" + phoneName + " " + model + ", " + numberOfSeconds
           + ", Account(" + accountName + "))";
  }//toString
}//class PhoneecLeft 

