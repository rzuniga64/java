package java_lessons.lesson31_graphics.awt;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;

@SuppressWarnings("serial")
public class Shapes extends java.applet.Applet {
	private Font f = new Font("TimesRoman", Font.BOLD, 36);
	
	public void paint(Graphics screen) {
		Dimension d = getSize();
		setBackground(Color.black);
		
		// Put text at the top of the window that says "Shapes"
		String s = "Shapes";
		drawString(s, Color.white, screen, d);
	
		// Each shape will use a third of the width of the applet
		// and will resize with the applet
		int w = d.width/3;
		int h = d.height/3;
		int radius = (int)((w < h) ? 0.4 * w : 0.4 * h);
		
		// Display a red square
		int x = w/2;
		int y = d.height/2;
		
		drawSquare(x, y, radius, Color.red, screen);
		
		//Display a yellow circle
		x = 3*w/2;
		y = d.height/2;

		drawCircle(x, y, radius, Color.yellow, screen);
	
		//Display a green circle
		x = 5*w/2;
		y = d.height/2;

		drawCircle(x, y, radius, Color.green, screen);
	}

	private void drawString(String s, Color c, Graphics screen, Dimension d){
		//Set font
		screen.setFont(f);
		
		// Get font metrics
		FontMetrics fm = screen.getFontMetrics();
		
		// Calculate starting position of string
		int x = d.width/2 - fm.stringWidth(s)/2;
		int y = d.height/4 - fm.getDescent();

		// Draw string
		screen.setColor(c);
		screen.drawString(s, x, y);
	}
	
	private void drawSquare(int x, int y, int radius, Color c, Graphics screen){
		screen.setColor(c);
		screen.drawRect(x - radius, y - radius, 2 * radius, 2 * radius );
		screen.fillRect(x - radius, y - radius, 2 * radius, 2 * radius);
	}
	
	private void drawCircle(int x, int y, int radius, Color c, Graphics screen){
		screen.setColor(c);
		screen.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);	
		screen.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}
}

	