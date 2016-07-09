package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Checkboxes extends java.applet.Applet {
	private Checkbox one = new Checkbox("Option 1");
	private Checkbox two = new Checkbox("Option 2");
	private Checkbox three = new Checkbox("Option 3");
	private Checkbox four = new Checkbox("Option 4");
	private Checkbox five = new Checkbox("Option 5");
	
	public void init() {
		add(one);
		add(two);
		three.setState(true);
		add(three);
		add(four);
		add(five);
	}
}
