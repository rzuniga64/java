package java_lessons.lesson32_graphics.eventhandling;

import java.applet.Applet;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class DrawLineApplet extends Applet {
	public void paint(Graphics g) {
		g.drawString("This is my first Applet", 20, 100);
	}

}
