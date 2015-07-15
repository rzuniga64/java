package java_lessons.lesson32_graphics.eventhandling;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MouseInnerDemo extends Applet {
	
	public void init() {
		setBackground(Color.green);
		addMouseListener(new MyMouseAdapter());
	}
	
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent me) {
			setBackground(Color.red);
			repaint();
		}
		
		public void mouseReleased(MouseEvent me) {
			setBackground(Color.green);
			repaint();
		}
	}

}
