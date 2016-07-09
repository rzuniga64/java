package java_lessons.lesson31_graphics.eventhandling;


import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CheckboxEvents extends Applet implements ItemListener {
	private Label label;
	
	public void init() {
		Checkbox cb1 = new Checkbox("Apple");
		cb1.addItemListener(this);
		add(cb1);
		Checkbox cb2 = new Checkbox("Banana");
		cb2.addItemListener(this);
		add(cb2);
		Checkbox cb3 = new Checkbox("Orange");
		cb3.addItemListener(this);
		add(cb3);
		label = new Label("Roy");
		add(label);		
	}
	
	public void itemStateChanged(ItemEvent ie) {
		Checkbox cb = (Checkbox) ie.getItemSelectable();
		label.setText(cb.getLabel()+ " " + cb.getState());
	}
}
