package java_lessons.lesson32_graphics.eventhandling;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CheckBoxGroupEvents extends Applet implements ItemListener {
	
	Label label;
	
	public void init() {
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("Apple", cbg, true);
		add(cb1);
		cb1.addItemListener(this);
		Checkbox cb2 = new Checkbox("Banana",cbg, false);
		add(cb2);
		cb2.addItemListener(this);
		Checkbox cb3 = new Checkbox("Orange", cbg, false);
		add(cb3);
		cb3.addItemListener(this);
		label = new Label("Roy");
		add(label);
	}
		public void itemStateChanged(ItemEvent ie) 
		{
			Checkbox cb = (Checkbox) ie.getItemSelectable();
			label.setText(cb.getLabel() + "  " + cb.getState());
		}
}
