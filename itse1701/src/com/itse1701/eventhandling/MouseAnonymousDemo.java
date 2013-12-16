package com.itse1701.eventhandling;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MouseAnonymousDemo extends java.applet.Applet {
	public void init() {
		setBackground(Color.green);
		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent me) {
				setBackground(Color.red);
				repaint();
			}
			
			public void mouseReleased(MouseEvent me) {
				setBackground(Color.green);
				repaint();
			}
		});
		
	}
}
