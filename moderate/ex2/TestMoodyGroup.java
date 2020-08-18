
public class TestMoodyGroup {
  public static void main(String[] args) {
    MoodyGroup<Teenager> teenChat = new MoodyGroup<Teenager>();
    
    Teenager teen = new Teenager("T 2");
    
    teenChat.addPerson(new Teenager("T 1"));
    teenChat.addPerson(teen);
    teenChat.addPerson(new Teenager("T 3"));
    
    System.out.printf("%s%n%n", teenChat);
    for (int count = 1; count <= teenChat.getSize(); count++) {
      teenChat.setHappy(false);
      System.out.printf("%s%n%n", teenChat);
    }// for
    
    System.out.printf("%s%n%n", teenChat);
    for (int count = 1; count <= teenChat.getSize(); count++) {
      teenChat.setHappy(true);
      System.out.printf("%s%n%n", teenChat);
    }// for
    
    MoodyGroup<MoodyPerson> anyChat = new MoodyGroup<MoodyPerson>();

    anyChat.addPerson(new Worker("W 1"));
    anyChat.addPerson(teen);

    System.out.printf("%s%n%n", anyChat);
    for (int count = 1; count <= anyChat.getSize(); count++) {
    	anyChat.setHappy(false);
      System.out.printf("%s%n%n", anyChat);
    }// for
    
    System.out.printf("%s%n%n", anyChat);
    for (int count = 1; count <= anyChat.getSize(); count++) {
    	anyChat.setHappy(true);
      System.out.printf("%s%n%n", anyChat);
    }// for
    
    System.out.printf("%s%n%n", teenChat);
    for (int count = 1; count <= teenChat.getSize(); count++) {
      System.out.printf("%s%n%n", teenChat);
    }// for
    
    
  }// main
}// class TestMoodyGroup
