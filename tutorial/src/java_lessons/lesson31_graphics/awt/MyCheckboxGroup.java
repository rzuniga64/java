package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class MyCheckboxGroup extends java.applet.Applet {
	private CheckboxGroup myGroup = new CheckboxGroup();

	private Checkbox one = new Checkbox("Option 1", myGroup, false);
	private Checkbox two = new Checkbox("Option 2", myGroup, false);
	private Checkbox three = new Checkbox("Option 3", myGroup, true);
	private Checkbox four = new Checkbox("Option 4", myGroup, false);
	private Checkbox five = new Checkbox("Option 5", myGroup, false);
	
	public void init() {
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
	}
}
