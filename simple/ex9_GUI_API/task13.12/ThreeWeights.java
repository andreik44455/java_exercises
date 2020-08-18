import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class ThreeWeights extends JFrame implements ActionListener {
  private final JTextField Wt1JTextField = new JTextField(5);
  private final JTextField Wt2JTextField = new JTextField(5);
  private final JTextField Wt3JTextField = new JTextField(5);

  private final JTextArea displayTextArea = new JTextArea(15, 20);
  
  public ThreeWeights() {
    setTitle("ThreeWeghts");
    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());
    
    JPanel WtsJPanel = new JPanel(new GridLayout(0,2));
    contents.add(WtsJPanel, BorderLayout.NORTH);
    WtsJPanel.add(new JLabel("First weight:"));
    WtsJPanel.add(Wt1JTextField);
    WtsJPanel.add(new JLabel("Second weight:"));
    WtsJPanel.add(Wt2JTextField);
    WtsJPanel.add(new JLabel("Third weight:"));
    WtsJPanel.add(Wt3JTextField);
    
    contents.add(new JScrollPane(displayTextArea), BorderLayout.CENTER);
    
    JButton displayJButton = new JButton("Display");
    contents.add(displayJButton, BorderLayout.SOUTH);
    displayJButton.addActionListener(this);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//ThreeWights
  
  public void actionPerformed (ActionEvent event)
  {
    displayTextArea.setText("");
    int Wt1 = Integer.parseInt(Wt1JTextField.getText());
    int Wt2 = Integer.parseInt(Wt2JTextField.getText());
    int Wt3 = Integer.parseInt(Wt3JTextField.getText());
    for (int count = -1; count<=1; count++)
      for (int count1 = -1; count1<=1; count1++)
        for (int count2 = -1; count2<=1; count2++)
    	  displayTextArea.append(Wt1*count+Wt2*count1+Wt3*count2+"\n");
    
  }//actionPerfomed
     
  public static void main(String[] args)
  {
    new ThreeWeights().setVisible(true);  
  }//main
}//class ThreeWeights
