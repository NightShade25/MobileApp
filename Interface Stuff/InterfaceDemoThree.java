import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class InterfaceDemoThree extends JPanel{

	public  InterfaceDemoThree(){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(600,600);
		frame.setVisible(true);
		setFocusable(true);

		addKeyListener(new KeyListener(){					//the anonymous way
			public void keyPressed(KeyEvent e){
				System.out.println(e.getKeyChar());
			}
			public void keyReleased(KeyEvent e){}
			public void keyTyped(KeyEvent e){}
			});	//can declare the whole class itself inside this
	}


	public static void main (String[]args){

		InterfaceDemoThree demo = new InterfaceDemoThree();

	}

}