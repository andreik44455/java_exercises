import java.awt.Color;

public class LotteryTestD {
  
  public static void main(String[] args) {
    SpeedController speedController
        = new SpeedController(SpeedController.HALF_SPEED);
    
    //create GUI
    LotteryGUI gui = new LotteryGUI("Test", speedController);
    
    //create 2 mahic workers and add to machine
    MagicWorker worker1 = new MagicWorker("Jim");
    MagicWorker worker2 = new MagicWorker("Tom");
    gui.addPerson(worker1);
    gui.addPerson(worker2);
  
    //create 2 games
    Game game1 = new Game("Lott O'Luck Larry", 28,
                                          "Slippery's Mile", 7);
    Game game2 = new Game("BLABLA", 49,
                                          "Hello", 7);
    //add games to GUI
    gui.addGame(game1);
    gui.addGame(game2);
    
    //fill machines by different workers
    worker1.fillMachine(game1);
    worker2.fillMachine(game2);

    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
      game1.ejectBall();
      speedController.delay(40);
    } // for

    for (int count = 1; count <= game2.getRackSize(); count ++)
    {
      game2.ejectBall();
      speedController.delay(40);
    } // for
  }//main
}//class LotteryTestD
