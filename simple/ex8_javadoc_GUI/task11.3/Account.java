public class Account 
{
  //Account has a provider name which cannot be changed
  private final String providerName;
  //amount of pence in the account
  private int balance = 0;

  //Account constructor
  public Account (String requiredProviderName)
  {
    providerName  = requiredProviderName;
  }
  
  //add money to account
  public int acceptTopUp(int pounds)
  {
	return balance += (100*pounds); 
  }//acceptTopUp
  
  //reduce balance on the account due to a call
  public void minusBalance(int seconds)
  {
    balance = balance - seconds;
  }
  
  //get name of the Provider
  public String getProviderName()
  {
    return providerName;
  }//getProviderName
	 
  //get balance in the account
  public int getAccountBalance()
  {
    return balance;
  }//getAccountBalance
  
  public String toString()
  {
    return providerName + ", " + balance;
  }
}//class Account

