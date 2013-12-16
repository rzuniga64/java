package com.itse1701.eventhandling;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ButtonEventRename extends Applet implements ActionListener {
	Button b;
	
	public void init() {
		b = new Button("Start");
		b.addActionListener(this);
		add(b);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (b.getLabel().equals("Start"))
			b.setLabel("Stop");
		else
			b.setLabel("Start");
				
	}
}

