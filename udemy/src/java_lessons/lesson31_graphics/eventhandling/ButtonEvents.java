package java_lessons.lesson31_graphics.eventhandling;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ButtonEvents extends Applet implements ActionListener
{	
	Label label;
	
	public void init(){
		Button b1 = new Button("Apple");
		b1.addActionListener(this);
		add(b1);
		Button b2 = new Button("Banana");
		b2.addActionListener(this);
		add(b2);
		Button b3 = new Button("Orange");
		b3.addActionListener(this);
		add(b3);
		label = new Label("Roy");
		add(label);
	}
	
	public void actionPerformed(ActionEvent ae) {
		label.setText(ae.getActionCommand());
	}
}
