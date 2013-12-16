package com.itse1701.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Buttons extends java.applet.Applet {
	Button one = new Button("Button 1");
	Button two = new Button("Button 2");
	Button three = new Button("Button 3");
	FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
	
	public void init() {
		setLayout(layout);
		add(one);
		add(two);
		add(three);
	}
}
