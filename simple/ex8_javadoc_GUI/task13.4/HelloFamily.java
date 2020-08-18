import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HelloFamily extends JFrame 
{
  public HelloFamily(int row, int column)
  {
    setTitle("Hello World in Spanish");
    Container  contents = getContentPane();
    contents.setLayout(new GridLayout(row, column, 20, 20));
    contents.add(new JLabel("Hello Andrei!"));
    contents.add(new JLabel("Hello Ann!"));
    contents.add(new JLabel("Hello Boris!"));
    contents.add(new JLabel("Hello Denis!"));
    contents.add(new JLabel("Hello Svetlana!"));
    contents.add(new JLabel("Hello Tatyana!"));
   
   
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    
  }//HelloWorld
  public static void main (String[] args)
  {
    int row = Integer.parseInt(args[0]);
    int column = Integer.parseInt(args[1]);
    HelloFamily TheHelloFamily = new HelloFamily(row, column);
    TheHelloFamily.setVisible(true);
    
  }//main
}//class HelloWorld

