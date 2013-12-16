package com.itse1701.awt;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PanelDemo extends Applet {
	
	public void init() {
	// Set layout manager
	setLayout(new BorderLayout());
	
	//Create a panel for "North"
	Panel pn = new Panel();
	Checkbox cb1 = new Checkbox("Red", true);
	pn.add(cb1);
	Checkbox cb2 = new Checkbox("Green", false);
	pn.add(cb2);
	Checkbox cb3 = new Checkbox("Blue", false);
	pn.add(cb3);
	add(pn, "North");
	
	//Create a panel for "Center"
	Panel pc = new Panel();
	pc.setLayout(new GridLayout(3,2));
	for(int i=0 ; i < 6; i++) 
		pc.add(new Button("Button" + i));
	add(pc, "Center");
	
	//Create a panel for "South"
	Panel ps = new Panel();
	Label label = new Label("This is the south Panel");
	ps.add(label);
	add(ps, "South");
	}
}
