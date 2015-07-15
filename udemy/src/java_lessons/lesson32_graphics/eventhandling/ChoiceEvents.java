package java_lessons.lesson32_graphics.eventhandling;


import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ChoiceEvents extends Applet implements ItemListener {
	Label label;
	Choice c1 = new Choice();
	Choice c2 = new Choice();
	
	public  void init() {
		c1.add("Red");
		c1.add("Orange");
		c1.add("Yellow");
		c1.add("Green");
		c1.add("Blue");
		c1.add("Indigo");
		c1.add("Violet");
		c1.addItemListener(this);
		add(c1);
		
		c2.add("North");
		c2.add("South");
		c2.add("East");
		c2.add("West");
		c2.addItemListener(this);
		add(c2);
		label = new Label("    ");
		add(label);
	}
	
	public void itemStateChanged (ItemEvent ie) {
		Choice c = (Choice) ie.getItemSelectable();
		label.setText(c.getSelectedItem());
	}
}
