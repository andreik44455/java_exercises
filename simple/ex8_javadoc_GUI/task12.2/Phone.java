/**
 * This class represents phones and provides certain manipulations of them. 
 *
 *
 * @author Andrei Korovin
 */
public class Phone
{
  //phone has a name and a model, and an account (both fixed)	
  private final String phoneName, model;  
  private Account accountName;
  //Total number of seconds during phone calls
  private int numberOfSeconds = 0;

  /**
   *Construct a phone.
   *
   *@param requiredPhoneName The required phone name.
   *@param requiredModel The required phone model.
   *@param requiredAccountName The required account name.
   */
  public Phone(String requiredPhoneName, String requiredModel,
               Account requiredAccountName)
  {
    phoneName = requiredPhoneName;
    model = requiredModel;
    accountName =  requiredAccountName;
  }//Phone
  
  /**
   *Get the account object.
   *
   *@return The accountName.
   */
  public Account getAccountName()
  {
    return accountName;
  }//getAccountName

  /**
   *Get the provider name of an account
   *
   *@return The provider name.
   */
  public String AccountName()
  {
    return accountName.getProviderName();
  }//AccountName

  /**
   *provides phone's name and model representation.
   *
   *@return A string phoneName model representation of the phone.
   */
  public String getPhone()
  {
    return phoneName + " " + model;
  }//getPhone
  
  /**
   *Get balance on the account
   *
   *@return The balance on the account.
   */
  public int getBalance()
  {
    return accountName.getAccountBalance();
  }//getBalance

  /**
   *calls method from the Account class so balance in the account is toped up.
   *
   *@param pounds Pounds that are topped up on the account.
   */
  public void toppingUp(int pounds)
  {
    accountName.acceptTopUp(pounds);
  }//toppingUp

  /**
   *Accept call and call minusBalance method so balance in the account
   *is reduced.
   *
   *@param sec The desired amount of seconds of the phone call.
   *
   *@return available number of seconds
   */
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
  
  /**
   *Checks whether the desired amount of seconds is more than balance
   * allows to call. If yes - true and vice versa.
   *
   *@param sec The desired amount of seconds of the phone call.
   *
   *@return True or False
   */
  public boolean compare(int sec)
  {
    int secCalled = sec;
    int balance = accountName.getAccountBalance();
    if (secCalled > balance)
	 return true;
               
    else return false;
  }//compare

  /**
   *Provides phone's name and model, total number of seconds called
   *provider name and balance on the account representation.
   *
   *@return A string Phone(phone name and model,
   *total number of seconds, Account(provider name, balance)) 
   */
  public String toString()
  {
    return "Phone(" + phoneName + " " + model + ", " + numberOfSeconds
           + ", Account(" + accountName + "))";
  }//toString
}//class PhoneecLeft 

