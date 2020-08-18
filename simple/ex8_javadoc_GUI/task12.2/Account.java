/**
 * This class represents accounts and provides certain manipulations of them. 
 *
 *
 * @author Andrei Korovin
 */
public class Account 
{
  //Account has a provider name which cannot be changed
  private final String providerName;
  //amount of pence in the account
  private int balance = 0;

  /**
   *Construct a phone.
   *
   *@param requiredProviderName The required provider name.
   */
  public Account (String requiredProviderName)
  {
    providerName  = requiredProviderName;
  }
  /**
   *Adds money to account
   *
   *@param pounds The pounds that are topped up on the account
   * 
   *@return An integer refreshed balance after topping up.
   */
  public int acceptTopUp(int pounds)
  {
	return balance += (100*pounds); 
  }//acceptTopUp
  
  /**
   *Reduce balance on the account due to a call.
   *
   *@param seconds The desired amount of seconds of the phone call.
   */
  public void minusBalance(int seconds)
  {
    balance = balance - seconds;
  }
  
  /**
   *Get name of the Provider.
   *
   *@return providerName The provider name.
   */
  public String getProviderName()
  {
    return providerName;
  }//getProviderName
  
  /** 
   *Get balance in the account
   *
   *@return balance The balance on the account.
   */
  public int getAccountBalance()
  {
    return balance;
  }//getAccountBalance
  
  /**
   *Provides provider name and balance on the account representation.
   *
   *@return A string provider name, balance 
   */
  public String toString()
  {
    return providerName + ", " + balance;
  }
}//class Account

