
public class DeliveryHouseDetails implements Comparable<DeliveryHouseDetails> {
	
private final int houseNumber;
private final String personName;

  public DeliveryHouseDetails(int reqHouseNumber, String reqPersonName) { 
    houseNumber = reqHouseNumber;
    personName = reqPersonName;
  }// DeliveryHouseDetails
  
  public String getPersonName() {
    return personName;
  }// getPersonName
  
  public int compareTo(DeliveryHouseDetails other) {
    if (other.houseNumber % 2 != 0 && houseNumber % 2 != 0)
      return houseNumber - other.houseNumber;
    else if (other.houseNumber % 2 == 0 && houseNumber % 2 == 0)
      return  other.houseNumber - houseNumber;
    else if (houseNumber % 2 != 0)
      return -1;
    else return 1;
  }// compareTo
  
  @Override
  public boolean equals(Object other) {
    if (other instanceof DeliveryHouseDetails)
      return houseNumber == ((DeliveryHouseDetails)other).houseNumber;
    else return super.equals(other);
  }//equals
}// class DeliveryHouseDetails
