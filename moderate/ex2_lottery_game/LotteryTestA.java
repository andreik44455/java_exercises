public class LotteryTestA {
  public static void main(String[] args){ 

  SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

  //create gui
  LotteryGUI gui = new LotteryGUI("Test", speedController);
  
  //create one instance of each kind of instantiable person,
  // adding it to the GUI.
  AudienceMember audienceMember1 = new AudienceMember("Ivana Di Yowt");
  gui.addPerson(audienceMember1);
  speedController.delay(40);

  Psychic psychic = new Psychic("Mr T. Peg de Gowt");
  gui.addPerson(psychic);
  speedController.delay(40);

  TVHost tvHost = new TVHost("Terry Bill Woah B'Gorne");
  gui.addPerson(tvHost);
  speedController.delay(40);

  Worker worker1 = new TraineeWorker("Jim", 0);
  gui.addPerson(worker1);
  speedController.delay(40);

  Punter punter1 = new Punter("Ian Arushfa Rishly Ving");
  gui.addPerson(punter1);
  speedController.delay(40);

  Director director = new Director("Sir Lance Earl Otto");
  gui.addPerson(director);
  speedController.delay(40);

  CleverPunter cleverPunter1 = new CleverPunter("Wendy Athinkile-Win");
  gui.addPerson(cleverPunter1);
  speedController.delay(40);

  Teenager teenager1 = new Teenager("Mike");
  gui.addPerson(teenager1);
  speedController.delay(40);

  }//main
}//class LotteryTestA
