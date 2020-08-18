import java.awt.Color;
public class LotteryTestC {
  public static void main(String[] args){
    SpeedController speedController
        = new SpeedController(SpeedController.HALF_SPEED);
    
    //create gui
    LotteryGUI gui = new LotteryGUI("Test", speedController);

    //create game and add to gui
    Game game1 = new Game("Lott O'Luck Larry", 12,
                          "Slippery's Mile", 12);
    gui.addGame(game1);

    //create balls and add them in the machine
    MagicBall ball1 = new MagicBall(2, Color.red);
    game1.machineAddBall(ball1);

    MagicBall ball2 = new MagicBall(4, Color.blue);
    game1.machineAddBall(ball2);

    MagicBall ball3 = new MagicBall(5, Color.yellow);
    game1.machineAddBall(ball3);
  }//main
}//LotteryTestC class
