import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld extends JFrame 
{
  public HelloWorld()
  {
    setTitle("Hello World in Spanish");
    Container  contents = getContentPane();
    contents.add(new JLabel("Saludos a todos los que habitan en el planeta Tierra!"));
   
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    
  }//HelloWorld
  public static void main (String[] args)
  {
    HelloWorld theHelloWorld = new HelloWorld();
    theHelloWorld.setVisible(true);
    HelloWorld theHelloWorld1 = new HelloWorld();
    theHelloWorld1.setVisible(true);
  }//main
}//class HelloWorld

