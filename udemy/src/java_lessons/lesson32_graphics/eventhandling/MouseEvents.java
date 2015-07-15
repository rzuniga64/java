package java_lessons.lesson32_graphics.eventhandling;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MouseEvents extends Applet implements MouseListener {
	
	public void init() {
		addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent me) {
		setBackground(Color.blue);
		repaint();
	}
	
	public void mouseEntered(MouseEvent me) {
		setBackground(Color.green);
		repaint();
	}
	
	public void mouseExited(MouseEvent me) {
		setBackground(Color.red);
		repaint();
	}
	
	public void mousePressed(MouseEvent me) {
		setBackground(Color.white);
		repaint();
	}
	
	public void mouseReleased(MouseEvent me) {
		setBackground(Color.yellow);
		repaint();
	}
}
