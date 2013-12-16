package com.itse1701.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Assignment2 extends java.applet.Applet {
	GridLayout mygrid = new GridLayout(2,3,7,7);
	
	Button b1 = new Button("button 1");
	Button b2 = new Button("button 2");
	Button b3 = new Button("button 3");
	
	Checkbox cb1 = new Checkbox("Option 1");
	Checkbox cb2 = new Checkbox("Option 2");
	Checkbox cb3 = new Checkbox("Option 3");
	
	public void init() {
		setLayout(mygrid);
		add(b1);
		add(b2);
		add(b3);
		add(cb1);
		cb1.setState(true);
		add(cb2);
		add(cb3);
	}
	
}
