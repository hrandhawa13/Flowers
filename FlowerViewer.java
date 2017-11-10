import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.*;

/**
 * This class is the main class that will run the program. 
 * @author Harmanjit Randhawa
 *
 */
public class FlowerViewer {
	public static void main ( String[] args ){
		
      final int HEIGHT = 700;
      final int WIDTH = 700;
		JFrame frame = new JFrame();
		frame.setSize(HEIGHT, WIDTH );
		frame.getContentPane().setBackground(Color.white);
		frame.setTitle( " FLOWERS ");
		int numFlowers = askUser();
		FlowerComponent FC = new FlowerComponent( numFlowers );
		frame.add( FC );
		
		frame.setVisible( true );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * This method asks user for input. 
	 * In this case it asks user to enter the number of flowers to be drawn on the screen.
	 * @return the input of user in integer format
	 */
   public static int askUser( ){
		String input = JOptionPane.showInputDialog(null, "How many Flowers would you like to draw? " , " FLOWERS :) ", JOptionPane.QUESTION_MESSAGE);
		return Integer.parseInt(input);
	}
}
