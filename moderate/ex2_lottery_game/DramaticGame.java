public class DramaticGame extends Game {
  //constructor
  public DramaticGame(String machineName, int machineSize,
              String rackName, int rackSize)
  {
    super(machineName, machineSize, rackName, rackSize); 
  } // DramaticGame
  
  //returns instance of Dramatic Machine and overrides supeclass's method
  public Machine makeMachine(String machineName, int machineSize)
  {
    return new DramaticMachine(machineName, machineSize);
  } // makeMachine
}//DramaticGame class
