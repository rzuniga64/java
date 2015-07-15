package java_lessons.lesson32_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Checkboxes extends java.applet.Applet {
	Checkbox one = new Checkbox("Option 1");
	Checkbox two = new Checkbox("Option 2");
	Checkbox three = new Checkbox("Option 3");
	Checkbox four = new Checkbox("Option 4");
	Checkbox five = new Checkbox("Option 5");
	
	public void init() {
		add(one);
		add(two);
		three.setState(true);
		add(three);
		add(four);
		add(five);
	}
}
