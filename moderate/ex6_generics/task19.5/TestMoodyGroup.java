
public class TestMoodyGroup {
  public static void main(String[] args) {
    // Create an instance of MoodyGroup with teenagers.
    MoodyGroup<Teenager> teenChat = new MoodyGroup<Teenager>();
    
    // Create an instance of a Teenager.
    Teenager teen = new Teenager("T 2");
    

    // Add 3 teenagers to MoodyGroup.
    teenChat.addPerson(new Teenager("T 1"));
    teenChat.addPerson(teen);
    teenChat.addPerson(new Teenager("T 3"));
    
    // Invoke setHappy() with false and print out the group.
    System.out.printf("%s%n%n", teenChat);
    for (int count = 1; count <= teenChat.getSize(); count++) {
      teenChat.setHappy(false);
      System.out.printf("%s%n%n", teenChat);
    }// for

    // Invoke setHappy() with true and print out the group.   
    System.out.printf("%s%n%n", teenChat);
    for (int count = 1; count <= teenChat.getSize(); count++) {
      teenChat.setHappy(true);
      System.out.printf("%s%n%n", teenChat);
    }// for
    
    // Create an instance of MoodyGroup with teenager and worker.
    MoodyGroup<MoodyPerson> anyChat = new MoodyGroup<MoodyPerson>();
 
    // Add 1 teenager and 1 worker to MoodyGroup.
    anyChat.addPerson(new Worker("W 1"));
    anyChat.addPerson(teen);

    // Invoke setHappy() with true and print out the group.
    System.out.printf("%s%n%n", anyChat);
    for (int count = 1; count <= anyChat.getSize(); count++) {
      anyChat.setHappy(true);
      System.out.printf("%s%n%n", anyChat);
    }// for
    
    // Invoke setHappy() with false and print out the group.
    System.out.printf("%s%n%n", anyChat);
    for (int count = 1; count <= anyChat.getSize(); count++) {
      anyChat.setHappy(false);
      System.out.printf("%s%n%n", anyChat);
    }// for
    
    // Print out the group.
    System.out.printf("%s%n%n", teenChat);

    
    
  }// main
}// class TestMoodyGroup
