import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class InterfaceDemoTwo extends JPanel{

	public  InterfaceDemoTwo(){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(600,600);
		frame.setVisible(true);
		setFocusable(true);
		KeyInterface ki = new KeyInterface();
		addKeyListener(new KeyInterface()); //either use anonymous class (new KeyInterface) or regular one (line above)
	}


	public static void main (String[]args){

		InterfaceDemoTwo demo = new InterfaceDemoTwo();

	}

	public class KeyInterface implements KeyListener{
		public void keyPressed(KeyEvent e){
			System.out.println(e.getKeyChar());
		}
		public void keyReleased(KeyEvent e){}

		public void keyTyped(KeyEvent e){}
	}
}