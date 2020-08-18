public class LotteryTestB {
  public static void main(String[] args){

    SpeedController speedController
        = new SpeedController(SpeedController.HALF_SPEED);
    //create worker
    Worker worker1 = new Worker("Jim");

    //create lottery GUI
    LotteryGUI gui = new LotteryGUI("Test", speedController);
    
    //create dramatic game
    DramaticGame game1 = new DramaticGame("Lott O'Luck Larry", 25,
                                          "Slippery's Mile", 3);

    gui.addGame(game1);
    worker1.fillMachine(game1);
  
    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
      speedController.delay(40);
      game1.ejectBall();
      
    } // for
  }//main
}//LotteryTestB class
