package com.itse1701.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class MyCheckboxGroup extends java.applet.Applet {
	CheckboxGroup myGroup = new CheckboxGroup();
	
	Checkbox one = new Checkbox("Option 1", myGroup, false);
	Checkbox two = new Checkbox("Option 2", myGroup, false);
	Checkbox three = new Checkbox("Option 3", myGroup, true);
	Checkbox four = new Checkbox("Option 4", myGroup, false);
	Checkbox five = new Checkbox("Option 5", myGroup, false);
	
	public void init() {
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
	}
}
