package com.itse1701.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Gridlayout extends java.applet.Applet {
	GridLayout buttons = new GridLayout(2,2,7,7);
	Button one = new Button("Button 1");
	Button two = new Button("Button 2");
	Button three = new Button("Button 3");
	Button four = new Button("Button 4");
	
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
