package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Buttons extends java.applet.Applet {
	private Button one = new Button("Button 1");
	private Button two = new Button("Button 2");
	private Button three = new Button("Button 3");
	private FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
	
	public void init() {
		setLayout(layout);
		add(one);
		add(two);
		add(three);
	}
}
