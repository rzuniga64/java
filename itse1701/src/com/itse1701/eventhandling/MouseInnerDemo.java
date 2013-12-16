package com.itse1701.eventhandling;

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
