package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Gridlayout extends java.applet.Applet {
	private GridLayout buttons = new GridLayout(2,2,7,7);
	private Button one = new Button("Button 1");
	private Button two = new Button("Button 2");
	private Button three = new Button("Button 3");
	private Button four = new Button("Button 4");
	
	public void init() {
		setLayout(buttons);
		add(one);
		add(two);
		add(three);
		add(four);
	}
	
	public Insets getInsets() {
		return new Insets(10, 10, 10, 10);
	}

}
