import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
public class StopClock extends JFrame implements ActionListener {
  private boolean isRunning = false;
  private long startTime = 0;
  private long stopTime = 0;
  private long splitTime = 0;
  
  private final JLabel startTimeJLabel = new JLabel("Not started");
  private final JLabel stopTimeJLabel = new JLabel("Not started");
  private final JLabel elapsedTimeJLabel = new JLabel("Not started");
  private final JLabel splitTimeJLabel = new JLabel("Not started");

  JButton startStopJButton = new JButton("Start/ Stop");
  JButton splitJButton = new JButton("Split");
  //Constructor
  public StopClock() {
    setTitle("Stop Clock");
    
    Container contents = getContentPane();
    contents.setLayout(new GridLayout(0, 1));
    
    contents.add(new JLabel("Started at:"));
    contents.add(startTimeJLabel);
    
    contents.add(new JLabel("Stopped at:"));
    contents.add(stopTimeJLabel);
    
    contents.add(new JLabel("Elapsed time (seconds):"));
    contents.add(elapsedTimeJLabel);
    
    contents.add(new JLabel ("Split time (seconds):"));
    contents.add(splitTimeJLabel);
    
    startStopJButton.addActionListener(this);
    contents.add(startStopJButton);
    
    splitJButton.addActionListener(this);
    contents.add(splitJButton);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//StopClock
  
  //Perform Action when the button is pressed.
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == startStopJButton) {
      if (!isRunning) {
        //Start the clock.
        startTime = System.currentTimeMillis();
        startTimeJLabel.setText("" + startTime);
        stopTimeJLabel.setText("Running...");
        elapsedTimeJLabel.setText("Running...");
        splitTimeJLabel.setText("Running...");
        isRunning = true;
      }//if
      else {
        //Stop the clock and show the updated time.
        stopTime = System.currentTimeMillis();
        stopTimeJLabel.setText("" + stopTime);
        long elapsedMilliSeconds = stopTime - startTime;
        elapsedTimeJLabel.setText("" + elapsedMilliSeconds/1000);
        splitTimeJLabel.setText("Stopped");
        isRunning = false;
      }//else
	}//if
	else {
	  if (isRunning) {
	    stopTime = System.currentTimeMillis();
            splitTime = stopTime - startTime;
            splitTimeJLabel.setText("" + splitTime/1000);
	    isRunning = true;
	  }//if
	  
	}//else
    pack();
    
  }//actionPerfomed
  
  //Create a StopClock and make it appear on screen.
  public static void main (String[] args) {
    StopClock theStopClock = new StopClock();
    theStopClock.setVisible(true);
  }//main
  
}//class StopClock

