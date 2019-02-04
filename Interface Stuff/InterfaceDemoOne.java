import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class InterfaceDemoOne extends JPanel implements KeyListener{

	public  InterfaceDemoOne(){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(600,600);
		frame.setVisible(true);
		setFocusable(true);
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyChar());
	}
	public void keyReleased(KeyEvent e){}

	public void keyTyped(KeyEvent e){}

	public static void main (String[]args){

		InterfaceDemoOne demo = new InterfaceDemoOne();

	}
}