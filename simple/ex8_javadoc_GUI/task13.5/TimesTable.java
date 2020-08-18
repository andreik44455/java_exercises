import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TimesTable extends JFrame 
{
  public TimesTable(int firstValue, int secondValue)
  {
    setTitle("TimesTable");
    Container  contents = getContentPane();
    
    contents.setLayout(new GridLayout(0, 5, 20, 20));
    for (int count=1; count<=firstValue; count++)
    {
      contents.add(new JLabel(count + ""));
      contents.add(new JLabel("*"));
      contents.add(new JLabel(secondValue + ""));
      contents.add(new JLabel("="));
      contents.add(new JLabel(secondValue*count+ ""));
    }//for
   
   
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    
  }//HelloWorld
  public static void main (String[] args)
  {
	int firstValue = Integer.parseInt(args[0]);
	int secondValue = Integer.parseInt(args[1]);
    TimesTable Table = new TimesTable(firstValue, secondValue);
    Table.setVisible(true);
    
  }//main
}//class HelloWorld

