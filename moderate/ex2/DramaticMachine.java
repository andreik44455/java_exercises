public class DramaticMachine extends Machine
{
  public DramaticMachine(String name, int size){
    super(name,size);
  }//DramaticMachine
 
  //Returns type and overrides supeclass's method
  public String getType() {
    return "Dramatic Machine";
  }//getType
  
  //Ejects a ball and overrides supeclass's method
  public Ball ejectBall() {
    if (getNoOfBalls() <= 0)
      return null;
    else {
      //pick a ball at random
      int ejectedBallIndex = (int) (Math.random() * getNoOfBalls())%getNoOfBalls();
      
      //starting with the first ball in the machine, each ball will
      //be flashed in turn, until the one to be ejected is reached.
      for ( int index = 0; index < ejectedBallIndex; index ++) {
        Ball flashedBall = getBall(index);
        flashedBall.flash(4, 5);
      }//for

      //eject a ball      
      Ball ejectedBall = getBall(ejectedBallIndex);

      ejectedBall.flash(4, 5); 

      //put the last one instead
      swapBalls(ejectedBallIndex, getNoOfBalls() - 1);
     
      //remove a ball     
      removeBall();


      return ejectedBall;
    }//else
  }//ejectBall
}//class DramaticMachine
