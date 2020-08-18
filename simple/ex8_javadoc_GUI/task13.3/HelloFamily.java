import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HelloFamily extends JFrame 
{
  public HelloFamily()
  {
    setTitle("Hello World in Spanish");
    Container  contents = getContentPane();
    contents.setLayout(new FlowLayout());
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
    HelloFamily TheHelloFamily = new HelloFamily();
    TheHelloFamily.setVisible(true);
    
  }//main
}//class HelloWorld

