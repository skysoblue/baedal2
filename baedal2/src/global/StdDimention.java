package global;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class StdDimention {
	public static void setPosition(JFrame frame, int width, int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = frame.getSize();
		int xpos = (int) (screen.getWidth()/2-frm.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2-frm.getHeight()/2);
		frame.setLocation(xpos,ypos);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
