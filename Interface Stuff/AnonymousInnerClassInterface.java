import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class AnonymousInnerClassInterface extends JPanel implements MouseListener{

	public  AnonymousInnerClassInterface(){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(600,600);
		frame.setVisible(true);
		setFocusable(true);

		addKeyListener(new KeyListener(){					//the anonymous way
			public void keyPressed(KeyEvent e){
				if(e.getKeyChar() == 'a' || e.getKeyChar() == 'e' || e.getKeyChar() == 'i' || e.getKeyChar() == 'o' || e.getKeyChar() == 'u' ){
				System.out.println("vowel was pressed");
				}else{ System.out.println("consonant was pressed");}
			}
			public void keyReleased(KeyEvent e){}
			public void keyTyped(KeyEvent e){}
		});	//can declare the whole class itself inside this

		addMouseListener (this);
	}
		public void mouseClicked(MouseEvent e){
			System.out.println(e.getLocationOnScreen());}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}




	public static void main (String[]args){

		AnonymousInnerClassInterface demo = new AnonymousInnerClassInterface();

	}

}